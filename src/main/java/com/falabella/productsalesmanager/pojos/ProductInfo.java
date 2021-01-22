package com.falabella.productsalesmanager.pojos;

public class ProductInfo {

	private String name;
	private Integer sellIn;
	private Integer price;
	
	public ProductInfo() {
	}
	
	public ProductInfo(String name, Integer sellIn, Integer price) {
		this.name = name;
		this.sellIn = sellIn;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSellIn() {
		return sellIn;
	}
	public void setSellIn(Integer sellIn) {
		this.sellIn = sellIn;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
