package com.example.bookercatalogddd.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreDto {
    Long id;
    String name;
    String address;
    String phone;
    String email;
    String sellerRef;
    List<ProductDto> products;
}
