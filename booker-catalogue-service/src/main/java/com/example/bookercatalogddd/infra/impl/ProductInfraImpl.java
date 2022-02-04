package com.example.bookercatalogddd.infra.impl;

import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.infra.core.AbstractInfraImpl;
import com.example.bookercatalogddd.infra.dao.ProductDao;
import com.example.bookercatalogddd.infra.entity.ProductEntity;
import com.example.bookercatalogddd.infra.facade.ProductInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInfraImpl extends AbstractInfraImpl implements ProductInfra {

    private final ProductDao productDao;

    @Override
    public int save(ProductEntity productEntity) {
        if (findByReference(productEntity.getReference()) != null)
            return -1;
        productDao.save(productEntity);
        return 1;
    }

    @Override
    public int update(ProductEntity productEntity) {
        if (findByReference(productEntity.getReference()) == null)
            return -1;
        productDao.save(productEntity);
        return 1;
    }

    @Override
    public int update(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        return update(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductEntity findByColor(String color) {
        return productDao.findByColor(color);
    }

    @Override
    public Product findByLibelle(String libelle) {
        ProductEntity productEntity = productDao.findByColor(libelle);
        Product product = new Product();
        if (productEntity != null) {
            BeanUtils.copyProperties(productEntity, product);
        }
        return product;
    }

    @Override
    public Product findByReference(String reference) {
        ProductEntity productEntity = productDao.findByColor(reference);
        Product product = new Product();
        if (productEntity != null) {
            BeanUtils.copyProperties(productEntity, product);
        }
        return product;
    }

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {
        return productDao.deleteByLibelle(libelle);
    }

    @Override
    @Transactional
    public int delete(Long id) {
        Optional<ProductEntity> productEntityOptional = productDao.findById(id);
        if (productEntityOptional.isPresent()) {
            productDao.delete(productEntityOptional.get());
            return 1;
        }
        return -1;

    }


}
