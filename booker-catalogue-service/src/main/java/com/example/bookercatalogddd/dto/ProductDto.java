package com.example.bookercatalogddd.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    String reference;
    String name;
    String image;
    BigDecimal price;
    String description;
    String color;
    CategoryDto category;
    Boolean active;
    StockDto stock;
    StoreDto store;
}
