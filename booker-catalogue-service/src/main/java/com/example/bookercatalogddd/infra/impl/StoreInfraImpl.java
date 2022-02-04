package com.example.bookercatalogddd.infra.impl;

import com.example.bookercatalogddd.infra.core.AbstractInfraImpl;
import com.example.bookercatalogddd.infra.dao.StoreDao;
import com.example.bookercatalogddd.infra.facade.StoreInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreInfraImpl extends AbstractInfraImpl implements StoreInfra {

    private final StoreDao storeDao;


}
