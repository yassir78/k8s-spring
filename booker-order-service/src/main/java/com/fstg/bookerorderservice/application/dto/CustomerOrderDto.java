package com.fstg.bookerorderservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerOrderDto {
    private Long id;
    private String ref;
    private String shipToAddress;
    private LocalDate orderDate;
    private LocalDate shipToDate;
    private String sellerRef;
    private String buyerRef;
    private BigDecimal orderAmount;
    private OrderStatusDto status;
    private List<OrderItemDto> orderItemDtos;
}
