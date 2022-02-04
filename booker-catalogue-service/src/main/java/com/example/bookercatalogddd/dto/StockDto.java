package com.example.bookercatalogddd.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class StockDto {
    Long id;
    Integer exposedQuantity;
    Integer availableQuantity;
}
