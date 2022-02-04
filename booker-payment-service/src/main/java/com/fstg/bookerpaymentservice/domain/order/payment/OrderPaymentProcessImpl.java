package com.fstg.bookerpaymentservice.domain.order.payment;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerpaymentservice.domain.core.Result;
import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderPaymentProcessImpl extends AbstractProcessImpl<OrderPaymentInput> implements OrderPaymentProcess {
    Logger logger = Logger.getLogger(OrderPaymentProcessImpl.class.getName());

    private final OrderInfra orderInfra;


    public void validate(OrderPaymentInput orderPaymentInput, Result result) {
        String reference = orderPaymentInput.getReference();
        logger.info("fetching order by reference started");
        Order order = orderInfra.findByReference(reference);
        logger.info("fetching order by reference started");
        if (order == null || order.getId() == null) {
            result.addErrorMessage(orderInfra.getMessage("order.payment.not_founded"));
        } else if (order.getTotalPaid().add(orderPaymentInput.getAmount()).compareTo(order.getOrderAmount()) > 0) {
            result.addErrorMessage(orderInfra.getMessage("order.payment.prob_payment"));
        }
    }

    public void run(OrderPaymentInput orderPaymentInput, Result result) {
        String reference = orderPaymentInput.getReference();
        Order order = orderInfra.findByReference(reference);
        order.setTotalPaid(order.getTotalPaid().add(orderPaymentInput.getAmount()));
        orderInfra.update(order);
        logger.log(Level.INFO, "updated order {}", order);
        result.addInfoMessage(orderInfra.getMessage("order.payment.created"));
    }


    public OrderPaymentProcessImpl(OrderInfra orderInfra) {
        this.orderInfra = orderInfra;
    }

}
