package com.example.bookercatalogddd.domain.product.delete;

import com.example.bookercatalogddd.domain.core.AbstractProcessInput;

public class ProductDeleteInput extends AbstractProcessInput {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
