package com.ilp.entity;

public class Account {
	private String accountNo;
	private Product product;
	private double accountBalance;

	public Account(String accountNo, Product product, double accountBalance) {
		this.accountNo = accountNo;
		this.product = product;
		this.accountBalance = accountBalance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
