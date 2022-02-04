package com.fstg.bookerpaymentservice.application.dto;

import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcessInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {

    private Long id;
    private String reference;
    private BigDecimal amount;
    private String orderReference;

    public static PaymentCreateProcessInput to(PaymentDto paymentDto) {
        PaymentCreateProcessInput paymentCreateProcessInput = new PaymentCreateProcessInput();
        BeanUtils.copyProperties(paymentDto, paymentCreateProcessInput.getPayment());
        paymentCreateProcessInput.setOrderReference(paymentDto.getOrderReference());
        return paymentCreateProcessInput;
    }
}
