package com.falabella.productsalesmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.repository.ProductRepository;
import com.falabella.productsalesmanager.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product saveNewEntry(Product obj) {
		return repo.save(obj);
	}

	@Override
	public Product modifyEntry(Product obj) {
		return repo.save(obj);
	}

	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
