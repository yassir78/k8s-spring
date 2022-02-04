package com.example.bookercatalogddd.infra.mapper;

import com.example.bookercatalogddd.domain.pojo.Store;
import com.example.bookercatalogddd.dto.StoreDto;
import com.example.bookercatalogddd.infra.entity.StoreEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper extends AbstractConverter<StoreEntity, Store, StoreDto> {
    @Override
    public Store entitytoPojo(StoreEntity entity) {
        Store store = new Store();
        store.setId(entity.getId());
        store.setName(entity.getName());
        store.setAddress(entity.getAddress());
        store.setPhone(entity.getPhone());
        store.setSellerRef(entity.getSellerRef());
        return store;
    }

    @Override
    public StoreDto pojotoDto(Store pojo) {
        StoreDto storeDto = new StoreDto();
        storeDto.setAddress(pojo.getAddress());
        storeDto.setPhone(pojo.getPhone());
        storeDto.setSellerRef(pojo.getSellerRef());
        storeDto.setEmail(pojo.getEmail());
        storeDto.setName(pojo.getName());
        return storeDto;
    }

    @Override
    public Store dtoToPojo(StoreDto dto) {
        Store store = new Store();
        store.setId(dto.getId());
        store.setName(dto.getName());
        store.setAddress(dto.getAddress());
        store.setPhone(dto.getPhone());
        store.setSellerRef(dto.getSellerRef());
        return store;
    }

    @Override
    public StoreEntity pojoToEntity(Store pojo) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setId(pojo.getId());
        storeEntity.setEmail(pojo.getEmail());
        storeEntity.setName(pojo.getName());
        storeEntity.setAddress(pojo.getAddress());
        storeEntity.setPhone(pojo.getPhone());
        storeEntity.setSellerRef(pojo.getSellerRef());
        return storeEntity;
    }
}
