package com.sumit.restapi.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is Item Enity which is use Item information")
@Entity
public class Item {

	// If we don't mention example the It will throw warning like
	// java.lang.NumberFormatException: For input string: ""
	@ApiModelProperty(notes="Item Id", example = "1")
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
	private String date;
	

	@Transient
	private int value;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", value=" + value
				+ "]";
	}
	
}
