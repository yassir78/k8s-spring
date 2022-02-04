package com.fstg.bookerpaymentservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long id;
    private String ref;
    private BigDecimal orderAmount;
    private BigDecimal totalPaid;
}