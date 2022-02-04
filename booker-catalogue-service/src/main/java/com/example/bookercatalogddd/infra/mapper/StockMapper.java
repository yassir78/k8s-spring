package com.example.bookercatalogddd.infra.mapper;

import com.example.bookercatalogddd.domain.pojo.Stock;
import com.example.bookercatalogddd.dto.StockDto;
import com.example.bookercatalogddd.infra.entity.StockEntity;
import org.springframework.stereotype.Component;

@Component
public class StockMapper extends AbstractConverter<StockEntity, Stock, StockDto> {
    @Override
    public Stock entitytoPojo(StockEntity entity) {
        Stock stock = new Stock();
        stock.setId(entity.getId());
        stock.setExposedQuantity(entity.getExposedQuantity());
        stock.setAvailableQuantity(entity.getAvailableQuantity());
        return stock;
    }

    @Override
    public StockDto pojotoDto(Stock pojo) {
        StockDto stockDto = new StockDto();
        stockDto.setExposedQuantity(pojo.getExposedQuantity());
        stockDto.setAvailableQuantity(pojo.getAvailableQuantity());
        return stockDto;
    }

    @Override
    public Stock dtoToPojo(StockDto dto) {
        Stock stock = new Stock();
        stock.setExposedQuantity(dto.getExposedQuantity());
        stock.setAvailableQuantity(dto.getAvailableQuantity());
        return stock;
    }

    @Override
    public StockEntity pojoToEntity(Stock pojo) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setAvailableQuantity(pojo.getAvailableQuantity());
        stockEntity.setExposedQuantity(pojo.getExposedQuantity());
        return stockEntity;
    }
}
