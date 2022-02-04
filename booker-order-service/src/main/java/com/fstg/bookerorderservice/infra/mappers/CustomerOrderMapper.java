package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateInput;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateInput;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomerOrderMapper extends AbstractConverter<CustomerOrderEntity, CustomerOrder, CustomerOrderDto> {

    private final OrderItemMapper orderItemMapper;
    private final OrderStatusMapper orderStatusMapper;

    @Override
    public CustomerOrder entityToPojo(CustomerOrderEntity entity) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(entity.getId());
        customerOrder.setOrderAmount(entity.getOrderAmount());
        customerOrder.setOrderDate(entity.getOrderDate());
        customerOrder.setTotalPaid(entity.getTotalPaid());
        customerOrder.setBuyerRef(entity.getBuyerRef());
        customerOrder.setSellerRef(entity.getSellerRef());
        customerOrder.setShipToAddress(entity.getShipToAddress());
        customerOrder.setShipToDate(entity.getShipToDate());
        customerOrder.setRef(entity.getRef());
        customerOrder.setOrderItems(orderItemMapper.entitiesToPojos(entity.getOrderItems()));
        customerOrder.setStatus(orderStatusMapper.entityToPojo(entity.getStatus()));
        return customerOrder;
    }

    @Override
    public CustomerOrderDto pojoToDto(CustomerOrder pojo) {
        CustomerOrderDto customerOrderDto = new CustomerOrderDto();
        customerOrderDto.setId(pojo.getId());
        customerOrderDto.setOrderAmount(pojo.getOrderAmount());
        customerOrderDto.setOrderDate(pojo.getOrderDate());
        customerOrderDto.setBuyerRef(pojo.getBuyerRef());
        customerOrderDto.setSellerRef(pojo.getSellerRef());
        customerOrderDto.setShipToAddress(pojo.getShipToAddress());
        customerOrderDto.setShipToDate(pojo.getShipToDate());
        customerOrderDto.setRef(pojo.getRef());
        customerOrderDto.setOrderItemDtos(orderItemMapper.pojosToDtos(pojo.getOrderItems()));
        customerOrderDto.setStatus(orderStatusMapper.pojoToDto(pojo.getStatus()));
        return customerOrderDto;
    }

    @Override
    public CustomerOrder dtoToPojo(CustomerOrderDto dto) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(dto.getId());
        customerOrder.setOrderAmount(dto.getOrderAmount());
        customerOrder.setOrderDate(dto.getOrderDate());
        customerOrder.setBuyerRef(dto.getBuyerRef());
        customerOrder.setSellerRef(dto.getSellerRef());
        customerOrder.setShipToAddress(dto.getShipToAddress());
        customerOrder.setShipToDate(dto.getShipToDate());
        customerOrder.setRef(dto.getRef());
        customerOrder.setOrderItems(orderItemMapper.dtosToPojos(dto.getOrderItemDtos()));
        if (dto.getStatus() != null) {
            customerOrder.setStatus(orderStatusMapper.dtoToPojo(dto.getStatus()));
        }

        return customerOrder;
    }

    @Override
    public CustomerOrderEntity pojoToEntity(CustomerOrder pojo) {
        CustomerOrderEntity customerOrderEntity = new CustomerOrderEntity();
        customerOrderEntity.setId(pojo.getId());
        customerOrderEntity.setOrderAmount(pojo.getOrderAmount());
        customerOrderEntity.setOrderDate(pojo.getOrderDate());
        customerOrderEntity.setTotalPaid(pojo.getTotalPaid());
        customerOrderEntity.setBuyerRef(pojo.getBuyerRef());
        customerOrderEntity.setSellerRef(pojo.getSellerRef());
        customerOrderEntity.setShipToAddress(pojo.getShipToAddress());
        customerOrderEntity.setShipToDate(pojo.getShipToDate());
        customerOrderEntity.setRef(pojo.getRef());
        customerOrderEntity.setOrderItems(orderItemMapper.pojosToEntites(pojo.getOrderItems()));
        customerOrderEntity.setStatus(orderStatusMapper.pojoToEntity(pojo.getStatus()));
        return customerOrderEntity;
    }

    public CustomerOrderCreateInput dtoToCreateInput(CustomerOrderDto dto) {
        CustomerOrderCreateInput customerOrderCreateInput = new CustomerOrderCreateInput();
        CustomerOrder customerOrder = this.dtoToPojo(dto);
        customerOrderCreateInput.setCustomerOrder(customerOrder);
        customerOrderCreateInput.setRef(dto.getRef());
        return customerOrderCreateInput;
    }

    public CustomerOrderUpdateInput dtoToUpdateInput(CustomerOrderDto dto) {
        CustomerOrderUpdateInput customerOrderUpdateInput = new CustomerOrderUpdateInput();
        customerOrderUpdateInput.setCustomerOrder(dtoToPojo(dto));
        return customerOrderUpdateInput;
    }
}
