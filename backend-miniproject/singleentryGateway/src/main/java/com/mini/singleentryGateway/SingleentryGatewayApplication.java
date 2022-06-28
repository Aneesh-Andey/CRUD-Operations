package com.mini.singleentryGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@Configuration
@EnableEurekaClient

public class SingleentryGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleentryGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator route(RouteLocatorBuilder routeLocatorBuilder)
	{

		return routeLocatorBuilder.routes().
				route(p->p.path("/user/**").uri("lb://user-comp"))
				.route(p->p.path("/movieuser/**").uri("lb://movie-comp"))
				.build();
	}

}
