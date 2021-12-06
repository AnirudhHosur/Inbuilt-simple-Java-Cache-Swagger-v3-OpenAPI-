package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer API", version = "2.0", description = "Customer CRUD Operations"))
@EnableCaching
public class DerbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DerbyApplication.class, args);
	}

}
