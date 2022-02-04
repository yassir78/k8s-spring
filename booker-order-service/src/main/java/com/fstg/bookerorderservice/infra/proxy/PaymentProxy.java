package com.fstg.bookerorderservice.infra.proxy;

import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.application.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentProxy {
    @PostMapping("/api/v1/payment/")
    public Result pay(@RequestBody PaymentDto paymentDto);
}
	      