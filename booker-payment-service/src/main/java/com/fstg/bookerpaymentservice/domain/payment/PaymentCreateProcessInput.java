package com.fstg.bookerpaymentservice.domain.payment;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessInput;
import com.fstg.bookerpaymentservice.domain.pojo.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateProcessInput extends AbstractProcessInput {
    private String orderReference;
    private Payment payment;


    public Payment getPayment() {
        if (payment == null) {
            payment = new Payment();
        }
        return payment;
    }


}
