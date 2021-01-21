package com.falabella.productsalesmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "simulation")
public class Simulation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer simulationId;

	@ManyToOne
    private Product product;
	
	@Column(name = "sell_in", nullable = false)
	private Integer sellIn;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@Column(name = "day_number", nullable = false)
	private Integer dayNumber;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@OneToMany(mappedBy = "simulation")
	private List<Sales> sales;

	public Simulation() {
	}

	public Simulation(Product product, Integer sellIn, Integer price, Integer dayNumber,
			Date date) {
		this.product = product;
		this.sellIn = sellIn;
		this.price = price;
		this.dayNumber = dayNumber;
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Simulation [simulationId=" + simulationId + ", product=" + product + ", sellIn=" + sellIn + ", price="
				+ price + ", dayNumber=" + dayNumber + ", date=" + date + "]";
	}
}
