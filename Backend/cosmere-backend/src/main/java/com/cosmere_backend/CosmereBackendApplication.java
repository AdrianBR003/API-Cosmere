package com.cosmere_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.cosmere_backend.Model")
@EnableJpaRepositories(basePackages = "com.cosmere_backend.Repository")
@ComponentScan(basePackages = "com.cosmere_backend")
public class CosmereBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmereBackendApplication.class, args);
	}
}
