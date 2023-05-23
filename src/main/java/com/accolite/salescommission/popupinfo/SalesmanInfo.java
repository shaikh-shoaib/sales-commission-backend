package com.accolite.salescommission.popupinfo;

public class SalesmanInfo {
	private String area;
	private int totalValue;
	private int commission;
	
	public SalesmanInfo() {	}
	
	public SalesmanInfo(String area, int totalValue, int commission) {
		super();
		this.area = area;
		this.totalValue = totalValue;
		this.commission = commission;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	
}
