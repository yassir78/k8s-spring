package com.example.bookercatalogddd.domain.pojo;

public class Stock {
    private Long id;
    private Integer exposedQuantity;
    private Integer availableQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExposedQuantity() {
        return exposedQuantity;
    }

    public void setExposedQuantity(Integer exposedQuantity) {
        this.exposedQuantity = exposedQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
