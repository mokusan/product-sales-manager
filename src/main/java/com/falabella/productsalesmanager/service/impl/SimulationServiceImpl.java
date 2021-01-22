package com.falabella.productsalesmanager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.repository.SimulationRepository;
import com.falabella.productsalesmanager.scheduler.ScheduledTasks;
import com.falabella.productsalesmanager.service.SimulationService;

@Service
public class SimulationServiceImpl implements SimulationService {

	@Autowired
	private SimulationRepository repo;
	
	@Autowired
	private ProductServiceImpl productService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Override
	public Simulation saveNewEntry(Simulation obj) {
		Date date = new Date();
		String productName = obj.getProduct().getName();
		Integer sellIn = obj.getSellIn();
		Integer price = obj.getPrice();
		Integer dayNumberCounter = obj.getDayNumberCounter() + 1;
		Simulation sim = new Simulation();
		
		if (productName.equals("Full cobertura") || productName.equals("Full cobertura Super duper")) {
			sellIn = obj.getSellIn() - 1;
			
			if (dayNumberCounter > 5 && dayNumberCounter <= 10) {
				price = price + 2;
				
			} else if (dayNumberCounter > 0 && dayNumberCounter <= 5) {
				price = price + 3;
				
			} else if (dayNumberCounter == 0) {
				price = 0;
			} else {
				price = price + 1;
				
			}
			sim = new Simulation(obj.getProduct(), sellIn, price < 0 ? 0 : price, dayNumberCounter, date);
			
		} else if (productName.equals("Super avance")) {
			sellIn = obj.getSellIn() - 1;
			price = price - 2;
			sim = new Simulation(obj.getProduct(), sellIn, price < 0 ? 0 : price, dayNumberCounter, date);
			
		} else if (productName.equals("Mega cobertura")) {
			price = 180;	
			sim = new Simulation(obj.getProduct(), sellIn, price, dayNumberCounter, date);
			
		} else {
			sellIn = obj.getSellIn() - 1;
			if (sellIn < 0) {
				price = price - 2;
			}
			sim = new Simulation(obj.getProduct(), sellIn, price < 0 ? 0 : price, dayNumberCounter, date);
		}
		return repo.save(sim);
	}

	@Override
	public Simulation modifyEntry(Simulation obj) {
		return repo.save(obj);
	}

	@Override
	public List<Simulation> listAll() {
		return repo.findAll();
	}

	@Override
	public Simulation findById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	public List<Simulation> findByDayNumber(Integer dayNumber) {
		return repo.findByDayNumberCounter(dayNumber);
	}
	
	public Simulation findLatestEntry() {
		return repo.findTopByOrderBySimulationIdDesc();
	}
	
	public Simulation createEntry(Simulation obj) {
		Date today = new Date();
		obj.setDayNumberCounter(0);
		obj.setDate(today);
		return repo.save(obj);
	}
	
	public List<Simulation> findByProductId(Integer id) {
		return repo.findByProduct_ProductId(id);
	}
	
	public List<Simulation> listOnlyAvailable() {
		
		List<Product> productsList = productService.listAll();		
		List<Simulation> simulationListToUpdate = new ArrayList<>();
		
		for ( Product p : productsList ) {
			List<Simulation> simulationListByProductId = findByProductId(p.getProductId());
			Simulation s = new Simulation();
			
			try {
				s = simulationListByProductId.get(simulationListByProductId.size()-1);
				if (s.getPrice() <= 0) {
					continue;
				}
				simulationListToUpdate.add(s);
			} catch (Exception e) {
//				e.printStackTrace();
				LOG.info("Favor crear un Simulation para el producto con ID: {} y NAME: {} ", p.getProductId(), p.getName());
			}			
		}
		return simulationListToUpdate;
	}
}
