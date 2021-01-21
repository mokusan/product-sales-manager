package com.falabella.productsalesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falabella.productsalesmanager.models.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer>{

}
