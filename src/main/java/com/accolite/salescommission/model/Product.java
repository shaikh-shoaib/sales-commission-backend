package com.accolite.salescommission.model;

public class Product {
	
	private String product_name;
	private int quantity;
	private int price_per_unit;
	private int salesman_id;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(int price_per_unit) {
		this.price_per_unit = price_per_unit;
	}
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	
}
