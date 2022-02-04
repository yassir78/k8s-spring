package com.fstg.bookerorderservice.infra.facade;

import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.core.AbstractInfra;

import java.math.BigDecimal;

public interface CustomerOrderInfra extends AbstractInfra {
    CustomerOrder findByReference(String reference);

    void sendEmail(CustomerOrder customerOrder);

    int deleteByReference(String reference);

    void update(CustomerOrder customerOrder);

    void save(CustomerOrder customerOrder);

    boolean userExistsByRef(String ref);

    boolean productExistsByRef(String ref);

    void pay(String ref, BigDecimal amount, String customerOrderRef);
}
