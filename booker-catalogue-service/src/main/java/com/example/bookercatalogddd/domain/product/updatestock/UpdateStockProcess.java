package com.example.bookercatalogddd.domain.product.updatestock;

import com.example.bookercatalogddd.domain.core.Result;

public interface UpdateStockProcess {
    Result execute(UpdateStockInput updateStockInput);
}
