package com.falabella.productsalesmanager;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.models.Sales;
import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.repository.ProductRepository;
import com.falabella.productsalesmanager.repository.SalesRepository;
import com.falabella.productsalesmanager.repository.SimulationRepository;

@SpringBootApplication
@EnableScheduling
public class ProductSalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSalesManagerApplication.class, args);
	}

	/**
	 * Precarga de data en BD
	 * 
	 */
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, 
									  SimulationRepository simulationRepository, 
									  SalesRepository salesRepository
									 ) {
		return (args) -> {
			
			// Create Products 
			productRepository.save(new Product("Full cobertura"));
			productRepository.save(new Product("Mega cobertura"));
			productRepository.save(new Product("Full cobertura Super duper"));
			productRepository.save(new Product("Super avance"));
			productRepository.save(new Product("Cobertura"));
			
			List<Product> productsList = productRepository.findAll();
			
			Date today = new Date();
			
			// Create Simulations for newly created Products
			for ( Product prod : productsList) {
				Random rand = new Random();
				if (prod.getName().contains("Mega cobertura")) {
					simulationRepository.save(new Simulation(prod, rand.nextInt(20) + 1, 180, 0, today));
				} else {
					simulationRepository.save(new Simulation(prod, rand.nextInt(20) + 1, rand.nextInt(100) + 1, 0, today));
				}
			} // end for productList	
			
		}; // end lambda
	} // end command line runner
}
