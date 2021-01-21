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

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "simulation")
public class Simulation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer simulationId;

	@ApiModelProperty
	@ManyToOne
    private Product product;
	
	@ApiModelProperty
	@Column(name = "sell_in", nullable = false)
	private Integer sellIn;
	
	@ApiModelProperty(notes = "Precio máximo = 180")
//	@Min(0)
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@ApiModelProperty(required = false, hidden = true)
	@Column(name = "day_number_counter", nullable = false)
	private Integer dayNumberCounter;
	
	@ApiModelProperty(required = false, hidden = true)
	@Column(name = "date", nullable = false)
	private Date date;
	
	@ApiModelProperty(required = false, hidden = true)
	@OneToMany(mappedBy = "simulation")
	private List<Sales> sales;

	public Simulation() {
	}

	public Simulation(Product product, Integer sellIn, Integer price, Integer dayNumberCounter,
			Date date) {
		this.product = product;
		this.sellIn = sellIn;
		this.price = price;
		this.dayNumberCounter = dayNumberCounter;
		this.date = date;
	}
	
	public Integer getSimulationId() {
		return simulationId;
	}

	public void setSimulationId(Integer simulationId) {
		this.simulationId = simulationId;
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

	public Integer getDayNumberCounter() {
		return dayNumberCounter;
	}

	public void setDayNumberCounter(Integer dayNumber) {
		this.dayNumberCounter = dayNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Simulation [simulationId=" + simulationId + ", product=" + product + ", sellIn=" + sellIn + ", price="
				+ price + ", dayNumberCounter=" + dayNumberCounter + ", date=" + date + "]";
	}
}
