package com.example.bookercatalogddd.domain.product.delete;

import com.example.bookercatalogddd.domain.core.Result;

public interface ProductDeleteProcess {
    Result execute(ProductDeleteInput productDeleteInput);
}
