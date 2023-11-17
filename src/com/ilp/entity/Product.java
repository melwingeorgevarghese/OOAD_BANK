package com.ilp.entity;

import java.util.ArrayList;

public class Product {
	private String productCode;
	private String productName;
	private ArrayList<Services> servicesList;

	public Product(String productCode, String productName, ArrayList<Services> servicesList) {
		this.productCode = productCode;
		this.productName = productName;
		this.servicesList = servicesList;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList<Services> getServicesList() {
		return servicesList;
	}

	public void setServicesList(ArrayList<Services> servicesList) {
		this.servicesList = servicesList;
	}

}
