package com.fstg.bookerpaymentservice.infra.config;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class SendMessage {
    private final Gson jsonConverter;

    public String buildMessage(Object payload) {
        MessageKafka messageKafka = new MessageKafka();
        messageKafka.setDate(new Date());
        messageKafka.setPayload(jsonConverter.toJson(payload));
        messageKafka.setProcessName("CustomerOrderCreateProcess");
        messageKafka.setMs("BOOKER_ORDER_SERVICE");
        return jsonConverter.toJson(messageKafka);
    }
}
