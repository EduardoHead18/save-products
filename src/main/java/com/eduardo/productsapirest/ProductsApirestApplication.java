package com.eduardo.productsapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApirestApplication.class, args);
		//test develop branch
		System.out.println("Server start on 🚀: http://3.142.35.109:8080/swagger-ui/index.html#/ ");
	}
}
