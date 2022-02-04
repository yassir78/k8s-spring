package com.example.bookercatalogddd.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer exposedQuantity;
    private Integer availableQuantity;
}
