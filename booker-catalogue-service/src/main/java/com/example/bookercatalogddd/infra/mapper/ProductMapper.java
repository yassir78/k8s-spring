package com.example.bookercatalogddd.infra.mapper;

import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.dto.ProductDto;
import com.example.bookercatalogddd.infra.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper extends AbstractConverter<ProductEntity, Product, ProductDto> {

    private final StockMapper stockMapper;
    private final CategoryMapper categoryMapper;
    private final StoreMapper storeMapper;

    @Override
    public Product entitytoPojo(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setActive(entity.getActive());
        product.setColor(entity.getColor());
        product.setReference(entity.getReference());
        product.setStock(stockMapper.entitytoPojo(entity.getStock()));
        product.setCategory(categoryMapper.entitytoPojo(entity.getCategory()));
        product.setStore(storeMapper.entitytoPojo(entity.getStore()));
        return product;
    }

    @Override
    public ProductDto pojotoDto(Product pojo) {
        ProductDto productDto = new ProductDto();
        productDto.setName(pojo.getName());
        productDto.setDescription(pojo.getDescription());
        productDto.setPrice(pojo.getPrice());
        productDto.setActive(pojo.getActive());
        productDto.setColor(pojo.getColor());
        productDto.setReference(pojo.getReference());
        productDto.setCategory(categoryMapper.pojotoDto(pojo.getCategory()));
        productDto.setStock(stockMapper.pojotoDto(pojo.getStock()));
        productDto.setStore(storeMapper.pojotoDto(pojo.getStore()));
        return productDto;
    }

    @Override
    public Product dtoToPojo(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setActive(dto.getActive());
        product.setColor(dto.getColor());
        product.setReference(dto.getReference());
        product.setCategory(categoryMapper.dtoToPojo(dto.getCategory()));
        product.setStock(stockMapper.dtoToPojo(dto.getStock()));
        product.setStore(storeMapper.dtoToPojo(dto.getStore()));
        return product;
    }

    @Override
    public ProductEntity pojoToEntity(Product pojo) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(pojo.getName());
        productEntity.setDescription(pojo.getDescription());
        productEntity.setPrice(pojo.getPrice());
        productEntity.setActive(pojo.getActive());
        productEntity.setColor(pojo.getColor());
        productEntity.setReference(pojo.getReference());
        productEntity.setStock(stockMapper.pojoToEntity(pojo.getStock()));
        productEntity.setCategory(categoryMapper.pojoToEntity(pojo.getCategory()));
        productEntity.setStore(storeMapper.pojoToEntity(pojo.getStore()));
        return productEntity;
    }
}
