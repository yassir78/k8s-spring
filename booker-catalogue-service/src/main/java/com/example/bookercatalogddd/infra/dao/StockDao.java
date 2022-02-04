package com.example.bookercatalogddd.infra.dao;

import com.example.bookercatalogddd.infra.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<StockEntity, Long> {
}
