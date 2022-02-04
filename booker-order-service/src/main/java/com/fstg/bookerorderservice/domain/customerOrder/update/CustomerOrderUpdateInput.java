package com.fstg.bookerorderservice.domain.customerOrder.update;

import com.fstg.bookerorderservice.domain.core.AbstractProcessInput;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;

public class CustomerOrderUpdateInput extends AbstractProcessInput {
    CustomerOrder customerOrder;

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
