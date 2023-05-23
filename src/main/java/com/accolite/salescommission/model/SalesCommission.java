package com.accolite.salescommission.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sales_commission")
public class SalesCommission {
	@Id
	@Column(name="primary_key")
	private int primaryKey;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_quantity")
	private int productQuantity;
	@Column(name="sales_amount")
	private double salesAmount;
	@Column(name="salesman_name")
	private String salesmanName;
	@Column(name="salesman_commission")
	private double salesmanCommission;
	@Column(name="salesman_area")
	private String salesmanArea;
	@Column(name="created_date")
	private LocalDate createdDate;
	
	public SalesCommission() {}
	
	public SalesCommission(int primaryKey, String productName, int productQuantity, double salesAmount, String salesmanName,
			double salesmanCommission, String salesmanArea, LocalDate createdDate) {
		super();
		this.primaryKey = primaryKey;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.salesAmount = salesAmount;
		this.salesmanName = salesmanName;
		this.salesmanCommission = salesmanCommission;
		this.salesmanArea = salesmanArea;
		this.createdDate = createdDate;
	}
	public int getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	public double getSalesmanCommission() {
		return salesmanCommission;
	}
	public void setSalesmanCommission(double salesmanCommission) {
		this.salesmanCommission = salesmanCommission;
	}
	public String getSalesmanArea() {
		return salesmanArea;
	}
	public void setSalesmanArea(String salesmanArea) {
		this.salesmanArea = salesmanArea;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

}
