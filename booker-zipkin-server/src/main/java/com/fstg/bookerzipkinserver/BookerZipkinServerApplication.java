package com.fstg.bookerzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class BookerZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookerZipkinServerApplication.class, args);
	}

}
