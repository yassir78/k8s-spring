package com.fstg.bookerorderservice.application.util;

import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateProcess;
import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateProcessImpl;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateProcess;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateProcessImpl;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessInjector {
    @Bean
    public CustomerOrderCreateProcess customerOrderCreateProcess(CustomerOrderInfra customerOrderInfra) {
        return new CustomerOrderCreateProcessImpl(customerOrderInfra);
    }

    @Bean
    public CustomerOrderUpdateProcess customerOrderUpdateProcess(CustomerOrderInfra customerOrderInfra) {
        return new CustomerOrderUpdateProcessImpl(customerOrderInfra);
    }
}
