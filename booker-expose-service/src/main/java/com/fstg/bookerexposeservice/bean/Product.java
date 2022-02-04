package com.fstg.bookerexposeservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String ref;
    private String name;
    private String description;
    private String image;
    private String price;
    private String category;

}
