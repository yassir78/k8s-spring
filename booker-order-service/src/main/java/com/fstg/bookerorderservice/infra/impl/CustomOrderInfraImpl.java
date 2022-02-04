package com.fstg.bookerorderservice.infra.impl;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.application.dto.PaymentDto;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.config.SendMessage;
import com.fstg.bookerorderservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerorderservice.infra.dao.CustomerOrderRepository;
import com.fstg.bookerorderservice.infra.dao.OrderItemRepository;
import com.fstg.bookerorderservice.infra.dao.OrderStatusRepository;
import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;
import com.fstg.bookerorderservice.infra.mappers.CustomerOrderMapper;
import com.fstg.bookerorderservice.infra.proxy.PaymentProxy;
import com.fstg.bookerorderservice.infra.proxy.ProductProxy;
import com.fstg.bookerorderservice.infra.proxy.UserProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CustomOrderInfraImpl extends AbstractInfraImpl implements CustomerOrderInfra {
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;
    private final OrderItemRepository orderItemRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final UserProxy userProxy;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ProductProxy productProxy;
    private final SendMessage sendMessage;
    private final PaymentProxy paymentProxy;
    @Value(value = "${kafka.order-topic}")
    private String orderTopic;
    @Value(value = "${kafka.pay-order-topic}")
    private String payOrderTopic;

    @Override
    public CustomerOrder findByReference(String reference) {
        CustomerOrderEntity customerOrderEntity = customerOrderRepository.findByRef(reference);
        if (customerOrderEntity != null) {
            System.out.println("zzzz " + customerOrderMapper.entityToPojo(customerOrderEntity).toString());
            return customerOrderMapper.entityToPojo(customerOrderEntity);
        } else {
            return new CustomerOrder();
        }
    }

    @Override
    public void sendEmail(CustomerOrder customerOrder) {
        CustomerOrderDto customerOrderDto = customerOrderMapper.pojoToDto(customerOrder);
        // send kafka message
        this.kafkaTemplate.send(orderTopic, sendMessage.buildMessage(customerOrderDto));
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return customerOrderRepository.deleteByRef(reference);
    }

    @Override
    public void update(CustomerOrder customerOrder) {
        this.save(customerOrder);
    }

    @Override
    public void save(CustomerOrder customerOrder) {
        CustomerOrderEntity customerOrderEntity = customerOrderMapper.pojoToEntity(customerOrder);
        orderStatusRepository.save(customerOrderEntity.getStatus());
        CustomerOrderEntity savedCustomerOrderEntity = customerOrderRepository.save(customerOrderEntity);
        customerOrderEntity.getOrderItems().forEach(orderItemEntity -> {
            orderItemEntity.setRelatedCustomerOrder(savedCustomerOrderEntity);
            orderItemRepository.save(orderItemEntity);
        });
    }

    @Override
    public boolean userExistsByRef(String ref) {
        return userProxy.existByRef(ref);
    }

    @Override
    public boolean productExistsByRef(String ref) {
        return productProxy.existByRef(ref);
    }

    @Override
    public void pay(String ref, BigDecimal amount, String customerOrderRef) {
        PaymentDto paymentDto = new PaymentDto(ref, amount, customerOrderRef);
        System.out.println("sent payment to kafka" + sendMessage.buildMessage(paymentDto));
        this.kafkaTemplate.send(payOrderTopic, sendMessage.buildMessage(paymentDto));
        // paymentProxy.pay(paymentDto);
    }


}
