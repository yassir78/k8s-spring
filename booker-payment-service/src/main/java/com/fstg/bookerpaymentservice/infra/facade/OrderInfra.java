package com.fstg.bookerpaymentservice.infra.facade;

import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfra;

public interface OrderInfra extends AbstractInfra {
    Order findByReference(String reference);
    void update(Order order);
   
}