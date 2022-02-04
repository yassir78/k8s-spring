package com.fstg.bookerorderservice.infra.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductProxy {
    @GetMapping("/api/v1/product/ref/{ref}")
    boolean existByRef(String ref);
}
