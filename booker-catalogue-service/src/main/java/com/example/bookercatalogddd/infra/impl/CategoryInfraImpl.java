package com.example.bookercatalogddd.infra.impl;

import com.example.bookercatalogddd.domain.pojo.Category;
import com.example.bookercatalogddd.infra.core.AbstractInfraImpl;
import com.example.bookercatalogddd.infra.dao.CategoryDao;
import com.example.bookercatalogddd.infra.entity.CategoryEntity;
import com.example.bookercatalogddd.infra.facade.CategoryInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryInfraImpl extends AbstractInfraImpl implements CategoryInfra {

    private final CategoryDao categoryDao;

    @Override
    public Category findByName(String name) {
        CategoryEntity categoryEntity = categoryDao.findByName(name);
        Category category = new Category();
        if (categoryEntity != null) {
            BeanUtils.copyProperties(categoryEntity, category);
        }
        return category;
    }

    @Override
    public int save(CategoryEntity categoryEntity) {
        if (findByName(categoryEntity.getName()) != null)
            return -1;
        categoryDao.save(categoryEntity);
        return 1;
    }

    @Override
    public int update(CategoryEntity categoryEntity) {
        if (findByName(categoryEntity.getName()) == null)
            return -1;
        categoryDao.save(categoryEntity);
        return 1;
    }

    @Override
    public int update(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category, categoryEntity);
        return update(categoryEntity);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryDao.findAll();
    }

    @Override
    @Transactional
    public Void deleteByName(String name) {
        return categoryDao.deleteByName(name);
    }


}
