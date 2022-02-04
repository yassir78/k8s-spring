package com.example.bookercatalogddd.domain.product.updatestock;

import com.example.bookercatalogddd.domain.core.AbstractProcessInput;

public class UpdateStockInput extends AbstractProcessInput {
    String productRef;
    Integer quantity;

    public String getProductRef() {
        return productRef;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
