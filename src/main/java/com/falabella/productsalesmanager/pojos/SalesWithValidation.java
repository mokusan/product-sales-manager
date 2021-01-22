package com.falabella.productsalesmanager.pojos;

import com.falabella.productsalesmanager.models.Sales;

public class SalesWithValidation {

	private Boolean isAvailable;
	private Sales sales;
	
	public SalesWithValidation() {
	}
	
	public SalesWithValidation(Boolean isAvailable, Sales sales) {
		this.isAvailable = isAvailable;
		this.sales = sales;
	}
	
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
}
