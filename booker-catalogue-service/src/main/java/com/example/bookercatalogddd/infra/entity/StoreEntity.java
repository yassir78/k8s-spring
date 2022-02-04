package com.example.bookercatalogddd.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String sellerRef;
    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<ProductEntity> products;
}
