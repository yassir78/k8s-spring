package com.example.bookercatalogddd.application.util;

import com.example.bookercatalogddd.domain.product.delete.ProductDeleteProcess;
import com.example.bookercatalogddd.domain.product.delete.ProductDeleteProcessImpl;
import com.example.bookercatalogddd.domain.product.updatestock.UpdateStockProcess;
import com.example.bookercatalogddd.domain.product.updatestock.UpdateStockProcessImpl;
import com.example.bookercatalogddd.infra.facade.ProductInfra;
import com.example.bookercatalogddd.infra.facade.StockInfra;
import com.example.bookercatalogddd.infra.facade.StoreInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessInjector {

    @Bean
    public ProductDeleteProcess productDeleteProcess(final ProductInfra productInfra) {
        return new ProductDeleteProcessImpl(productInfra);
    }

    @Bean
    public UpdateStockProcess updateStockProcess(final ProductInfra productInfra, final StockInfra stockInfra, final StoreInfra storeInfra) {
        return new UpdateStockProcessImpl(productInfra, stockInfra, storeInfra);
    }
}
