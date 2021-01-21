package com.falabella.productsalesmanager.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.service.SimulationService;
import com.falabella.productsalesmanager.service.impl.SimulationServiceImpl;

@Component
public class ScheduledTasks {
	
	@Autowired
	private SimulationServiceImpl simulationService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	 
//	private SimulationRepository simulationRepository;
//	 
//	@Autowired
//	public ScheduledTasks(SimulationRepository simulationRepository) {
//		this.simulationRepository = simulationRepository;
//	}
	 
	@Scheduled(cron = "${cron.expression}")
	public void dailyTasks() {  
		LOG.info("Actualización periódica de Sell-in y Price de Productos :: Hora de ejecución- {}",
	                dateTimeFormatter.format(LocalDateTime.now()));
		 
		Date today = new Date();
		 
		// Retrieve latest entry to obtain dayNumberCounter
		Simulation simLatestEntry = simulationService.findLatestEntry();
		
		List<Simulation> simulationListfromPreviousDay = simulationService.findByDayNumber(simLatestEntry.getDayNumberCounter()); 
		 
		for ( Simulation s : simulationListfromPreviousDay ) {
			simulationService.saveNewEntry(s);
		}
	}
}
