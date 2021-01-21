package com.falabella.productsalesmanager.service;

import java.util.List;

public interface ICRUD <T> {
	
	T saveNewEntry(T obj);
	T modifyEntry(T obj);
	List<T> listAll();
	T findById(Integer id);
	boolean delete(Integer id);
	
}