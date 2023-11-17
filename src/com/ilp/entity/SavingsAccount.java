package com.ilp.entity;

import java.util.ArrayList;

public class SavingsAccount extends Product {
	double minBalance;

	public SavingsAccount(String productCode, String productName, ArrayList<Services> servicesList, double minBalance) {
		super(productCode, productName, servicesList);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

}
