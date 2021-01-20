package com.falabella.productsalesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductSalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSalesManagerApplication.class, args);
	}

}
