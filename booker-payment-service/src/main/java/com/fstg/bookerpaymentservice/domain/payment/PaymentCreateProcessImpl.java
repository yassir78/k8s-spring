package com.fstg.bookerpaymentservice.domain.payment;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerpaymentservice.domain.core.Result;
import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.domain.pojo.Payment;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.facade.PaymentInfra;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PaymentCreateProcessImpl extends AbstractProcessImpl<PaymentCreateProcessInput> implements PaymentCreateProcess {

    Logger logger = Logger.getLogger(PaymentCreateProcessImpl.class.getName());

    @Override
    public void validate(PaymentCreateProcessInput abstractProcessInput, Result result) {
        logger.info("Payment create process validate");
        order = orderInfra.findByReference(abstractProcessInput.getOrderReference());
        Payment payment = paymentInfra.findByReference(abstractProcessInput.getPayment().getReference());
        System.out.println("payment valdiate : " + payment.toString());
        System.out.println("order valdiate : " + order.toString());
        if (order == null) {
            result.addErrorMessage("payment.create.order_not_founded");
        } else if (order.getTotalPaid().add(abstractProcessInput.getPayment().getAmount()).compareTo(order.getTotalPaid()) < 0) {
            result.addErrorMessage("payment.create.amount_invalid");
        }
        if (payment != null && payment.getId() != null) {
            result.addErrorMessage("payment.create.payment_already_exists");
        }
    }

    @Override
    public void run(PaymentCreateProcessInput abstractProcessInput, Result result) {
        Payment payment = abstractProcessInput.getPayment();
        payment.setOrderReference(order.getRef());
        order.setTotalPaid(order.getTotalPaid().add(payment.getAmount()));
        orderInfra.update(order);
        paymentInfra.save(payment);
        result.addInfoMessage("payment.create.payment_created");
    }

    public PaymentCreateProcessImpl(PaymentInfra paymentInfra, OrderInfra orderInfra) {
        this.paymentInfra = paymentInfra;
        this.orderInfra = orderInfra;
    }


    private final PaymentInfra paymentInfra;
    private final OrderInfra orderInfra;
    private Order order;
}
