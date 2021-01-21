package com.falabella.productsalesmanager.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.service.SimulationService;
import com.falabella.productsalesmanager.service.impl.ProductServiceImpl;
import com.falabella.productsalesmanager.service.impl.SimulationServiceImpl;

@Component
public class ScheduledTasks {
	
	@Autowired
	private SimulationServiceImpl simulationService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	/**
	 * dailyTasks executes validations and updates prices and sellIn
	 */
	@Scheduled(cron = "${cron.expression}")
	public void dailyTasks() {  
		LOG.info("Actualización periódica de Sell-in y Price de Productos :: Hora de ejecución- {}",
	                dateTimeFormatter.format(LocalDateTime.now()));
		 
		Date today = new Date();
		 
		/**
		 * Create list of simulations to update
		 */		
		List<Product> productsList = productService.listAll();		
		List<Simulation> simulationListToUpdate = new ArrayList<>();
		
		for ( Product p : productsList ) {
			List<Simulation> simulationListByProductId = simulationService.findByProductId(p.getProductId());
			Simulation s = simulationListByProductId.get(simulationListByProductId.size()-1);
			simulationListToUpdate.add(s);
		}
		
		// 
		 
		for ( Simulation s : simulationListToUpdate ) {
//			simulationService.saveNewEntry(s);
			System.out.println(s.toString());
		}
	}
}
