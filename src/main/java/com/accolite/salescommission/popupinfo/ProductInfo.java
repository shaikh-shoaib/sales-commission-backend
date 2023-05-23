package com.accolite.salescommission.popupinfo;

public class ProductInfo {
	private String area;
	private int totalQuantity;
	private int totalSales;
	
	public ProductInfo() {	}
	
	public ProductInfo(String area, int totalQuantity, int totalSales) {
		super();
		this.area = area;
		this.totalQuantity = totalQuantity;
		this.totalSales = totalSales;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
}
