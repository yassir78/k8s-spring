package com.fstg.bookerorderservice.domain.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String reference;
    private double amount;
    private String orderReference; 
}
