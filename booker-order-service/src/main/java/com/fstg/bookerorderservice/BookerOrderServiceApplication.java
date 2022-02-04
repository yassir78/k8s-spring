package com.fstg.bookerorderservice;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class BookerOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookerOrderServiceApplication.class, args);
    }

    @Bean
    public Gson jsonConverter() {
        return new Gson();
    }
}
