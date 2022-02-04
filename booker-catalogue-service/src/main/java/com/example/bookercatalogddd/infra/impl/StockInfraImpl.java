package com.example.bookercatalogddd.infra.impl;

import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.domain.pojo.Stock;
import com.example.bookercatalogddd.infra.core.AbstractInfraImpl;
import com.example.bookercatalogddd.infra.dao.StockDao;
import com.example.bookercatalogddd.infra.entity.ProductEntity;
import com.example.bookercatalogddd.infra.entity.StockEntity;
import com.example.bookercatalogddd.infra.facade.ProductInfra;
import com.example.bookercatalogddd.infra.facade.StockInfra;
import com.example.bookercatalogddd.infra.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockInfraImpl extends AbstractInfraImpl implements StockInfra {

    private final StockDao stockDao;
    private final ProductInfra productInfra;
    private final StockMapper stockMapper;

    @Override
    public int save(StockEntity stockEntity) {
        return 0;
    }


    @Override
    public void updateStock(String productRef, int quantity) {
        // TODO document why this method is empty
    }

    @Override
    public void update(Stock stock) {
        StockEntity stockEntity = stockMapper.pojoToEntity(stock);
        if (stockEntity.getId() != null) {
            stockDao.save(stockEntity);
        }
    }

    @Override
    public List<StockEntity> findAll() {
        return null;
    }

    @Override
    public StockEntity findById(Long id) {
        return null;
    }

    @Override
    public StockEntity findByProductId(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int deleteByProductId(Long id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public int deleteByProduct(Product product) {
        return 0;
    }

    @Override
    public int deleteByProduct(ProductEntity productEntity) {
        return 0;
    }

    @Override
    public int deleteByProduct(Stock stock) {
        return 0;
    }

    @Override
    public int deleteByProduct(StockEntity stockEntity) {
        return 0;
    }

    @Override
    public int deleteByProduct(List<Stock> stockList) {
        return 0;
    }
}
