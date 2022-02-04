package com.example.bookercatalogddd.infra.dao;

import com.example.bookercatalogddd.infra.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByColor(String color);

    void deleteByColor(String color);

    ProductEntity findByLibelle(String libelle);

    ProductEntity findByReference(String reference);

    int deleteByLibelle(String libelle);

}
