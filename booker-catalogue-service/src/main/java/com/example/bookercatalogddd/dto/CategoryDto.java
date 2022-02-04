package com.example.bookercatalogddd.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class CategoryDto {
    private String name;
    private String description;
}
