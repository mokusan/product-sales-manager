package com.falabella.productsalesmanager.pojos;

import java.util.List;

public class EvaluateProducts {

	private Integer day;
	private List<ProductInfo> productInfo;	
	
	public EvaluateProducts() {
	}

	public EvaluateProducts(Integer day) {
		this.day = day;
	}
	
	public EvaluateProducts(Integer day, List<ProductInfo> productInfo) {
		this.day = day;
		this.productInfo = productInfo;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
}
