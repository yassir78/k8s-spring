package com.fstg.bookerpaymentservice.infra.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentSearch {

    private String reference;
    private Double amountMin;
    private Double amountMax;

}
