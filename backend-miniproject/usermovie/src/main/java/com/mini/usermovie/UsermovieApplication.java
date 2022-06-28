package com.mini.usermovie;

import com.mini.usermovie.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@CrossOrigin
public class UsermovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermovieApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new JwtFilter());
		filterBean.addUrlPatterns("/movieuser/getdata/*");
		return filterBean;
	}

}
