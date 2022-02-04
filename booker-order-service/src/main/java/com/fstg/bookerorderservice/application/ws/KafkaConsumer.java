package com.fstg.bookerorderservice.application.ws;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateInput;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateProcess;
import com.fstg.bookerorderservice.infra.config.MessageKafka;
import com.fstg.bookerorderservice.infra.mappers.CustomerOrderMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final Gson jsonConverter;
    private final CustomerOrderMapper customerOrderMapper;
    private final CustomerOrderUpdateProcess customerOrderUpdateProcess;

    @KafkaListener(topics = "${kafka.update-order-topic}", groupId = "groupId")
    public void updateOrder(String message) {
        System.out.println("Received message: " + message);
        MessageKafka msg = jsonConverter.fromJson(message, MessageKafka.class);
        CustomerOrderDto order = jsonConverter.fromJson(msg.getPayload(), CustomerOrderDto.class);
        CustomerOrderUpdateInput updateInput = customerOrderMapper.dtoToUpdateInput(order);
        System.out.println("updateInput: " + updateInput.getCustomerOrder().toString());
        customerOrderUpdateProcess.execute(updateInput);
        System.out.println("updateInput: " + updateInput);
    }
}
