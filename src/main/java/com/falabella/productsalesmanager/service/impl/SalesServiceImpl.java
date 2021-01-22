package com.falabella.productsalesmanager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.productsalesmanager.models.Sales;
import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.pojos.EvaluateProducts;
import com.falabella.productsalesmanager.pojos.ProductInfo;
import com.falabella.productsalesmanager.repository.SalesRepository;
import com.falabella.productsalesmanager.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository repo;
	
	@Autowired
	private SimulationServiceImpl simulationService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Override
	public Sales saveNewEntry(Sales obj) {
		Date today = new Date();
		obj.setDate(today);
		return repo.save(obj);
	}

	@Override
	public Sales modifyEntry(Sales obj) {
		return repo.save(obj);
	}

	@Override
	public List<Sales> listAll() {
		return repo.findAll();
	}

	@Override
	public Sales findById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}

	public List<EvaluateProducts> getEvaluateProducts(Integer days) {
		List<EvaluateProducts> evaluateProductsList = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			// fetch all simulations by day
			List<Simulation> simulationsByDay = simulationService.findByDayNumber(i);
			
			// create new productInfo element and list
			List<ProductInfo> productInfoList = new ArrayList<>();
			EvaluateProducts evaluateProduct = new EvaluateProducts(i);
			
			// fill productInfo list
			for (Simulation sim : simulationsByDay) {
				String productName = (productService.findById(sim.getProduct().getProductId())).getName();
//				ProductInfo prodInfo = new ProductInfo(productName, sim.getSellIn(), sim.getPrice());
				productInfoList.add(new ProductInfo(productName, sim.getSellIn(), sim.getPrice()));		
			}
			
			// fill evasluate products list
			evaluateProduct.setProductInfo(productInfoList);
			evaluateProductsList.add(evaluateProduct);
		}
		return evaluateProductsList;
	}
	
}
