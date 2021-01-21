package com.falabella.productsalesmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falabella.productsalesmanager.models.Simulation;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Integer>{

	List<Simulation> findByDayNumberCounter(Integer dayNumberCounter);
	
	Simulation findTopByOrderBySimulationIdDesc();
}
