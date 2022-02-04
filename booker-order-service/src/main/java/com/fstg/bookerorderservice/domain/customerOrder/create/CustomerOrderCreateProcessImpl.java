package com.fstg.bookerorderservice.domain.customerOrder.create;

import com.fstg.bookerorderservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.domain.pojo.OrderItem;
import com.fstg.bookerorderservice.domain.pojo.OrderStatus;
import com.fstg.bookerorderservice.infra.entity.enums.Status;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

public class CustomerOrderCreateProcessImpl extends AbstractProcessImpl<CustomerOrderCreateInput> implements CustomerOrderCreateProcess {
    private final CustomerOrderInfra customerOrderInfra;
    Logger logger = Logger.getLogger(CustomerOrderCreateProcessImpl.class.getName());

    @Override
    public void validate(CustomerOrderCreateInput abstractProcessInput, Result result) {
        String ref = abstractProcessInput.getRef();
        CustomerOrder customerOrder = customerOrderInfra.findByReference(ref);
        if (customerOrder.getId() != null) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.paiment.not_founded"));
        } else {
            logger.info("customerOrder " + abstractProcessInput.getCustomerOrder().toString());
            if (!customerOrderInfra.userExistsByRef(abstractProcessInput.getCustomerOrder().getSellerRef())) {
                result.addErrorMessage(customerOrderInfra.getMessage("commande.seller.not_founded"));
            }
            if (!customerOrderInfra.userExistsByRef(abstractProcessInput.getCustomerOrder().getBuyerRef())) {
                result.addErrorMessage(customerOrderInfra.getMessage("commande.buyer.not_founded"));
            }
            validateOrderItems(abstractProcessInput.getCustomerOrder().getOrderItems(), result);
            validateOrderDate(abstractProcessInput.getCustomerOrder().getOrderDate(), result);
            validateShipToDate(abstractProcessInput.getCustomerOrder().getShipToDate(), result);
        }
        logger.info("Validation finished");

    }

    @Override
    public void run(CustomerOrderCreateInput abstractProcessInput, Result result) {
        CustomerOrder customerOrder = abstractProcessInput.getCustomerOrder();
        customerOrder.setStatus(createOrderStatus(Status.UNPAID));
        customerOrder.setTotalPaid(BigDecimal.ZERO);
        customerOrderInfra.save(customerOrder);
        result.addInfoMessage(customerOrderInfra.getMessage("commande.status.saved"));
        //send email to buyer
        customerOrderInfra.sendEmail(customerOrder);
        //Payment
        logger.info("Payment proccess started");
        String reference = UUID.randomUUID().toString();
        customerOrderInfra.pay(reference, customerOrder.getOrderAmount(), customerOrder.getRef());
        result.addInfoMessage(customerOrderInfra.getMessage("commande.payment.saved"));

    }

    public CustomerOrderCreateProcessImpl(CustomerOrderInfra customerOrderInfra) {
        this.customerOrderInfra = customerOrderInfra;
    }

    private OrderStatus createOrderStatus(Status status) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(status.toString());
        return orderStatus;
    }

    private void validateOrderItems(List<OrderItem> orderItems, Result result) {
        if (Objects.isNull(orderItems)) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.item.not_valid"));

        } else {
            orderItems.stream().map(OrderItem::getProductRef).forEach(ref -> {
                //if (!customerOrderInfra.productExistsByRef(ref))
                //   result.addErrorMessage(customerOrderInfra.getMessage("commande.item.not_founded"));
            });
        }

    }

    private void validateOrderDate(LocalDate orderDate, Result result) {
        LocalDate today = LocalDate.now();
        if (orderDate.isAfter(today)) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.date.not_valid"));
        }
    }

    private void validateShipToDate(LocalDate shipToDate, Result result) {
        LocalDate today = LocalDate.now();
        if (shipToDate.isBefore(today)) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.date.not_valid"));
        }
    }
}
