package com.spring.microservice.cloud.gateway.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix

public class CloudGatewayHystrixClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayHystrixClientApplication.class, args);
	}

}
