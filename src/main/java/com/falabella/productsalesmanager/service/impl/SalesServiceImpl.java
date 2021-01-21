package com.falabella.productsalesmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.productsalesmanager.models.Sales;
import com.falabella.productsalesmanager.repository.SalesRepository;
import com.falabella.productsalesmanager.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository repo;
	
	@Override
	public Sales saveNewEntry(Sales obj) {
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

	
}
