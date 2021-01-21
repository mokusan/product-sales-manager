package com.falabella.productsalesmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.models.Simulation;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Integer>{

	List<Simulation> findByDayNumberCounter(Integer dayNumberCounter);
	
	Simulation findTopByOrderBySimulationIdDesc();
	
//x	Simulation findByDayNumberCounterAndProductId(Integer dayNumberCounter, Integer id); 
	
//x	Simulation findTopByOrderByProduct_ProductIdDesc(Product id);
	
	List<Simulation> findByProduct_ProductId(Integer id);
	
//x	Simulation findTopByOrderByProduct_Name(String p);
	
//*	List<Simulation> findByProduct_NameAndDayNumberCounter(String p, Integer dayNumberCounter);
	
//*	Simulation findFirstByDayNumberCounterAndProduct_Name(Integer dayNumberCounter, String p);

}
