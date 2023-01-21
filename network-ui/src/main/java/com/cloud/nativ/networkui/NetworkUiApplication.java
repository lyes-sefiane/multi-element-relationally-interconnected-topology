package com.cloud.nativ.networkui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetworkUiApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(NetworkUiApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
		springApplication.run(args);
	}

}
