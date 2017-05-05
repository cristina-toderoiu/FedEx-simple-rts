package com.ppb.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RetailSimpleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailSimpleBackendApplication.class, args);
	}
}
