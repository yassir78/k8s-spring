package com.fstg.bookerpaymentservice.application.ws;

import com.fstg.bookerpaymentservice.application.dto.PaymentDto;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcess;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcessInput;
import com.fstg.bookerpaymentservice.infra.config.MessageKafka;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final Gson jsonConverter;
    private final PaymentCreateProcess paymentCreateProcess;

    @KafkaListener(topics = "${kafka.pay-order-topic}", groupId = "groupId")
    public void payOrder(String message) {
        System.out.println("'payOrder' message received: " + message);
        MessageKafka msg = jsonConverter.fromJson(message, MessageKafka.class);
            PaymentDto paymentDto = jsonConverter.fromJson(msg.getPayload(), PaymentDto.class);
        System.out.println("PaymentDto : " + paymentDto.toString());
        PaymentCreateProcessInput paymentCreateProcessInput = PaymentDto.to(paymentDto);
        paymentCreateProcess.execute(paymentCreateProcessInput);
    }
}
