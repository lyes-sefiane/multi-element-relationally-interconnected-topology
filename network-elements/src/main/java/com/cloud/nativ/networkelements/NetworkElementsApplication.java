package com.cloud.nativ.networkelements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NetworkElementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkElementsApplication.class, args);
	}

}
