package com.integration.test.integrationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class IntegrationtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationtestApplication.class, args);
	}
}
