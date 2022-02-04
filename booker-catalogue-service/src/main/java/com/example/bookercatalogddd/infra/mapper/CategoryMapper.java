package com.example.bookercatalogddd.infra.mapper;

import com.example.bookercatalogddd.domain.pojo.Category;
import com.example.bookercatalogddd.dto.CategoryDto;
import com.example.bookercatalogddd.infra.entity.CategoryEntity;

public class CategoryMapper extends AbstractConverter<CategoryEntity, Category, CategoryDto> {
    @Override
    public Category entitytoPojo(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setDescription(entity.getDescription());
        return category;
    }

    @Override
    public CategoryDto pojotoDto(Category pojo) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(pojo.getName());
        categoryDto.setDescription(pojo.getDescription());
        return categoryDto;
    }

    @Override
    public Category dtoToPojo(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    @Override
    public CategoryEntity pojoToEntity(Category pojo) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(pojo.getName());
        categoryEntity.setDescription(pojo.getDescription());
        return categoryEntity;
    }
}
