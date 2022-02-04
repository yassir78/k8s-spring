package com.fstg.bookerorderservice.domain.customerOrder.create;

import com.fstg.bookerorderservice.domain.core.AbstractProcessInput;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;

public class CustomerOrderCreateInput extends AbstractProcessInput {
    String ref;
    CustomerOrder customerOrder;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
