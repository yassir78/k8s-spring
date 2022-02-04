package com.booker.bookereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookerEurekaServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookerEurekaServiceRegistryApplication.class, args);
    }

}
