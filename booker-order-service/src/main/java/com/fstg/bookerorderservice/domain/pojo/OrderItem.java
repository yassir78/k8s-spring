package com.fstg.bookerorderservice.domain.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderItem {
    private Long id;
    private Integer quantity;
    private BigDecimal total;
    private String productRef;
    private CustomerOrder relatedCustomerOrder;
}
