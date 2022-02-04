package com.example.bookercatalogddd.infra.facade;

import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.infra.core.AbstractInfra;
import com.example.bookercatalogddd.infra.entity.CategoryEntity;
import com.example.bookercatalogddd.infra.entity.ProductEntity;

import java.util.List;

public interface ProductInfra extends AbstractInfra {

    int save(ProductEntity productEntity);

    int update(ProductEntity productEntity);


    int update(Product product);

    List<ProductEntity> findAll() ;

    ProductEntity findByColor(String color);

    Product findByLibelle(String libelle);

    Product findByReference(String reference);

    int deleteByLibelle(String libelle);

    int delete(Long id);


}
