package com.fstg.bookerpaymentservice.infra.facade;

import com.fstg.bookerpaymentservice.domain.pojo.Payment;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfra;

public interface PaymentInfra extends AbstractInfra {
	Payment findByReference(String reference);

    int deleteByReference(String reference);

    int save(Payment payment);


}
