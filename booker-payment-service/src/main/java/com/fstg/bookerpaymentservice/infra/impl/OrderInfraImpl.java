package com.fstg.bookerpaymentservice.infra.impl;

import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.config.SendMessage;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.proxy.OrderProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderInfraImpl extends AbstractInfraImpl implements OrderInfra {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.update-order-topic}")
    private String updateOrderTopic;
    private final SendMessage sendMessage;

    @Override
    public Order findByReference(String reference) {
        return orderProxy.findByReference(reference);
    }


    @Override
    public void update(Order oder) {
        //orderProxy.update(oder);
        this.kafkaTemplate.send(updateOrderTopic, sendMessage.buildMessage(oder));
    }


    @Autowired
    private OrderProxy orderProxy;
}
