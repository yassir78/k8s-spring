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
public class Payment {
    private Long id;
    private String reference;
    private BigDecimal amount;
    private String orderReference;
    
}