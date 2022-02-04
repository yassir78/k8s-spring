package com.example.bookercatalogddd.infra.dao;

import com.example.bookercatalogddd.infra.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao extends JpaRepository<StoreEntity, Long> {
}
