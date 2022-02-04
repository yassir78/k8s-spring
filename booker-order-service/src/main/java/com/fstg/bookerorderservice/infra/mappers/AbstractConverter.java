package com.fstg.bookerorderservice.infra.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractConverter<K, V, T> {

    public abstract V entityToPojo(K entity);

    public abstract T pojoToDto(V pojo);

    public abstract V dtoToPojo(T dto);

    public abstract K pojoToEntity(V pojo);

    public List<V> entitiesToPojos(List<K> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<V> items = new ArrayList<>();
            for (K entity : entities) {
                items.add(entityToPojo(entity));
            }
            return items;
        }
    }

    public List<K> pojosToEntites(List<V> pojos) {
        if (pojos == null || pojos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<K> entities = new ArrayList<>();
            for (V pojo : pojos) {
                entities.add(pojoToEntity(pojo));
            }
            return entities;
        }
    }

    public List<T> pojosToDtos(List<V> pojos) {
        if (pojos == null || pojos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<T> dtos = new ArrayList<>();
            for (V pojo : pojos) {
                dtos.add(pojoToDto(pojo));
            }
            return dtos;
        }
    }

    public List<V> dtosToPojos(List<T> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<V> pojos = new ArrayList<>();
            for (T dto : dtos) {
                pojos.add(dtoToPojo(dto));
            }
            return pojos;
        }
    }

}
