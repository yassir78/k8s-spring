package com.fstg.bookerorderservice.infra.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface UserProxy {
    @GetMapping("/api/v1/account/ref/{ref}")
    boolean existByRef(@PathVariable String ref);
}
