package com.example.bookercatalogddd.infra.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="booker-product-service",url="localhost:8085")
public interface ProductProxy {
}
