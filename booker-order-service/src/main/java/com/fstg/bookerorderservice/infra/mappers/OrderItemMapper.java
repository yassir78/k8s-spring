package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.OrderItemDto;
import com.fstg.bookerorderservice.domain.pojo.OrderItem;
import com.fstg.bookerorderservice.infra.entity.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemMapper extends AbstractConverter<OrderItemEntity, OrderItem, OrderItemDto> {
    @Override
    public OrderItem entityToPojo(OrderItemEntity entity) {
        OrderItem pojo = new OrderItem();
        pojo.setId(entity.getId());
        pojo.setProductRef(entity.getProductRef());
        pojo.setTotal(entity.getTotal());
        pojo.setQuantity(entity.getQuantity());
        return pojo;
    }

    @Override
    public OrderItemDto pojoToDto(OrderItem pojo) {
        OrderItemDto dto = new OrderItemDto();
        dto.setId(pojo.getId());
        dto.setProductRef(pojo.getProductRef());
        dto.setQuantity(pojo.getQuantity());
        dto.setTotal(pojo.getTotal());
        return dto;
    }

    @Override
    public OrderItem dtoToPojo(OrderItemDto dto) {
        OrderItem pojo = new OrderItem();
        pojo.setId(dto.getId());
        pojo.setProductRef(dto.getProductRef());
        pojo.setQuantity(dto.getQuantity());
        pojo.setTotal(dto.getTotal());
        return pojo;
    }

    @Override
    public OrderItemEntity pojoToEntity(OrderItem pojo) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(pojo.getId());
        entity.setProductRef(pojo.getProductRef());
        entity.setQuantity(pojo.getQuantity());
        entity.setTotal(pojo.getTotal());
        return entity;
    }
}
