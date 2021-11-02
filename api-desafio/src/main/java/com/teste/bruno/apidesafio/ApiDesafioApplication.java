package com.teste.bruno.apidesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class ApiDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDesafioApplication.class, args);
	}

}
