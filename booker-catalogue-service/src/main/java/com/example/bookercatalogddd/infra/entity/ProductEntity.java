package com.example.bookercatalogddd.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String name;
    private String image;
    private BigDecimal price;
    @Lob
    private String description;
    private String color;
    @OneToOne
    private CategoryEntity category;
    private Boolean active;
    @OneToOne
    private StockEntity stock;
    @ManyToOne
    private StoreEntity store;



}
