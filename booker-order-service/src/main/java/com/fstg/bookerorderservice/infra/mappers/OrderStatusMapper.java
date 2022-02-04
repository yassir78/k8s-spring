package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.OrderStatusDto;
import com.fstg.bookerorderservice.domain.pojo.OrderStatus;
import com.fstg.bookerorderservice.infra.entity.OrderStatusEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderStatusMapper extends AbstractConverter<OrderStatusEntity, OrderStatus, OrderStatusDto> {
    @Override
    public OrderStatus entityToPojo(OrderStatusEntity entity) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(entity.getId());
        orderStatus.setStatus(entity.getStatus());

        return orderStatus;
    }

    @Override
    public OrderStatusDto pojoToDto(OrderStatus pojo) {
        OrderStatusDto orderStatusDto = new OrderStatusDto();
        orderStatusDto.setId(pojo.getId());
        orderStatusDto.setStatus(pojo.getStatus());
        return orderStatusDto;
    }

    @Override
    public OrderStatus dtoToPojo(OrderStatusDto dto) {
      OrderStatus orderStatus = new OrderStatus();
      orderStatus.setStatus(dto.getStatus());
      return orderStatus;
    }

    @Override
    public OrderStatusEntity pojoToEntity(OrderStatus pojo) {
        OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
        orderStatusEntity.setId(pojo.getId());
        orderStatusEntity.setStatus(pojo.getStatus());
        return orderStatusEntity;
    }
}