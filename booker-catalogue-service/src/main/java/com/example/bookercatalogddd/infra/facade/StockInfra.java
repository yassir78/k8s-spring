package com.example.bookercatalogddd.infra.facade;

import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.domain.pojo.Stock;
import com.example.bookercatalogddd.infra.core.AbstractInfra;
import com.example.bookercatalogddd.infra.entity.ProductEntity;
import com.example.bookercatalogddd.infra.entity.StockEntity;

import java.util.List;

public interface StockInfra extends AbstractInfra {

    int save(StockEntity stockEntity);


    void updateStock(String productRef, int quantity);

    void update(Stock stock);

    List<StockEntity> findAll();


    StockEntity findById(Long id);

    StockEntity findByProductId(Long id);

    int deleteById(Long id);

    int deleteByProductId(Long id);

    int deleteAll();

    int deleteByProduct(Product product);

    int deleteByProduct(ProductEntity productEntity);

    int deleteByProduct(Stock stock);

    int deleteByProduct(StockEntity stockEntity);

    int deleteByProduct(List<Stock> stockList);

}
