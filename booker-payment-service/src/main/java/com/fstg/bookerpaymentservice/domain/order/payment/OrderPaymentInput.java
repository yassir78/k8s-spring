package com.fstg.bookerpaymentservice.domain.order.payment;

import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessInput;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderPaymentInput extends AbstractProcessInput {
    String reference;
    BigDecimal amount;
}
