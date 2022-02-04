package com.example.bookercatalogddd.infra.dao;

import com.example.bookercatalogddd.infra.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findByName(String name);

    Void deleteByName(String name);
}
