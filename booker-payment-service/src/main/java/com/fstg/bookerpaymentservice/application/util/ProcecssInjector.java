package com.fstg.bookerpaymentservice.application.util;

import com.fstg.bookerpaymentservice.domain.order.payment.OrderPaymentProcess;
import com.fstg.bookerpaymentservice.domain.order.payment.OrderPaymentProcessImpl;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcess;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcessImpl;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.facade.PaymentInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcecssInjector {

    @Bean
    public OrderPaymentProcess orderPaymentProcess(OrderInfra orderInfra) {
        return new OrderPaymentProcessImpl(orderInfra);
    }

    @Bean
    public PaymentCreateProcess paymentCreateProcess(PaymentInfra paymentInfra, OrderInfra orderInfra) {
        return new PaymentCreateProcessImpl(paymentInfra, orderInfra);
    }
}
