package com.example.eurekeregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekeregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekeregistryApplication.class, args);
	}

}
