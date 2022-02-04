package com.fstg.bookerorderservice.domain.customerOrder.update;

import com.fstg.bookerorderservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.domain.pojo.OrderStatus;
import com.fstg.bookerorderservice.infra.entity.enums.Status;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;

import java.util.logging.Logger;

public class CustomerOrderUpdateProcessImpl extends AbstractProcessImpl<CustomerOrderUpdateInput> implements CustomerOrderUpdateProcess {

    private final CustomerOrderInfra customerOrderInfra;

    Logger logger = Logger.getLogger(CustomerOrderUpdateProcessImpl.class.getName());
    CustomerOrder customerOrder;

    @Override
    public void validate(CustomerOrderUpdateInput abstractProcessInput, Result result) {
        // Validation
        validateCustomerOrder(abstractProcessInput, result);
        validateCustomerOrderAmount(abstractProcessInput, result);

    }

    @Override
    public void run(CustomerOrderUpdateInput abstractProcessInput, Result result) {
        // Run
        customerOrder.setTotalPaid(customerOrder.getTotalPaid().add(abstractProcessInput.getCustomerOrder().getOrderAmount()));
        customerOrder.setOrderAmount(abstractProcessInput.getCustomerOrder().getOrderAmount());
        customerOrder.setStatus(createOrderStatus(Status.PAID));
        customerOrderInfra.update(customerOrder);
        result.addInfoMessage(customerOrderInfra.getMessage("commande.paiment.amount.updated"));
    }

    private void validateCustomerOrder(CustomerOrderUpdateInput abstractProcessInput, Result result) {
        customerOrder = customerOrderInfra.findByReference(abstractProcessInput.getCustomerOrder().getRef());
        if (customerOrder == null || customerOrder.getId() == null) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.paiment.not_founded"));
        }
    }

    private void validateCustomerOrderAmount(CustomerOrderUpdateInput abstractProcessInput, Result result) {
        CustomerOrder inputCustomerOrder = abstractProcessInput.getCustomerOrder();
        if (inputCustomerOrder.getOrderAmount().compareTo(customerOrder.getTotalPaid()) < 0) {
            result.addErrorMessage(customerOrderInfra.getMessage("commande.paiment.amount.not_founded"));
        }
    }

    private OrderStatus createOrderStatus(Status status) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(status.toString());
        return orderStatus;
    }

    public CustomerOrderUpdateProcessImpl(CustomerOrderInfra customerOrderInfra) {
        this.customerOrderInfra = customerOrderInfra;
    }

}
