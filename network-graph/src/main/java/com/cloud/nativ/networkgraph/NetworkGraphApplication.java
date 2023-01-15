package com.cloud.nativ.networkgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NetworkGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkGraphApplication.class, args);
	}

}
