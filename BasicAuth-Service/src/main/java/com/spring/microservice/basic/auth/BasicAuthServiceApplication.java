package com.spring.microservice.basic.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity

public class BasicAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthServiceApplication.class, args);
	}

}
