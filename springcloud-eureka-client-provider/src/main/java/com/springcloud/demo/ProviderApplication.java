package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) {
		//new SpringApplicationBuilder(ClientApplication.class).web(true).run(args);
		SpringApplication.run(ProviderApplication.class, args);
	}
}
