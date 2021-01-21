package com.falabella.productsalesmanager.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	 private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
	 private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	 
	 @Scheduled(cron = "${cron.expression}")
	 public void dailyTasks() {  
		 LOG.info("Actualización periódica de Sell-in y Price de Productos :: Hora de ejecución- {}",
	                dateTimeFormatter.format(LocalDateTime.now()));
	 }
}
