package com.example.bookercatalogddd.infra.facade;

import com.example.bookercatalogddd.domain.pojo.Category;
import com.example.bookercatalogddd.infra.core.AbstractInfra;
import com.example.bookercatalogddd.infra.entity.CategoryEntity;

import java.util.List;

public interface CategoryInfra extends AbstractInfra {

    Category findByName(String name);

    int save(CategoryEntity categoryEntity);

    int update(CategoryEntity categoryEntity);

    int update(Category category);

    List<CategoryEntity> findAll();

    Void deleteByName(String name);

}
