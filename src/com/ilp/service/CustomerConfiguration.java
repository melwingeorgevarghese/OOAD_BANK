package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Services;

public class CustomerConfiguration {
	public static Customer createCustomer(Customer customer, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		ArrayList<Account> accountList = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("****Accounts Available***********");
		int count = 1;
		for (Product product : productList) {
			System.out.println(count + "." + product.getProductName());
			count++;
		}
		int choice = scanner.nextInt();

		if (customer == null) {
			System.out.println("Create a new Account");
			System.out.println("Enter Customer Name:");
			String customerName = scanner.next();
			System.out.println("Enter Customer Code");
			String customerCode = scanner.next();
			accountList.add(CustomerConfiguration.createAccount(choice, productList));
			customer = new Customer(customerCode, customerName, accountList);
			createSuccessMsg(customer);
		} else {
			accountList = customer.getAccountList();
			accountList.add(CustomerConfiguration.createAccount(choice, productList));
			customer.setAccountList(accountList);
			createSuccessMsg(customer);
		}
		return customer;
	}

	public static void createSuccessMsg(Customer customer) {
		System.out.println("Account created for " + customer.getCustomerName() + " with the following Services");

		Account account = customer.getAccountList().getLast();
		Product product = account.getProduct();
		for (Services services : product.getServicesList()) {
			System.out.println(services.getServiceName());
		}

		System.out.println("Account is active!");
	}

	public static void displayCustomer(Customer customer) {
		// TODO Auto-generated method stub

		System.out.println("*************************Customer-Account Details****************");
		System.out.println("Customer Id" + "     " + "Customer Name" + "     " + "AccountType" + "     " + "Balance");
		System.out.println("***************************************************************");
		for (Account account : customer.getAccountList())
			System.out.println(customer.getCustomerCode() + "     " + customer.getCustomerName() + "     "
					+ account.getProduct().getProductName() + "     " + account.getAccountBalance());
		System.out.println("Services");
		for (Account account : customer.getAccountList()) {
			Product product = account.getProduct();
			System.out.println("For " + product.getProductName());
			for (Services services : product.getServicesList()) {
				System.out.println(services.getServiceName());
			}
		}
	}

	public static void transactionBill(Customer customer, String customerId) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		if (customer.getCustomerCode().equals(customerId)) {
			System.out.println(customer.getCustomerName() + " has the following accounts:");
			int count = 1;
			for (Account account : customer.getAccountList()) {
				System.out.println(count + "." + account.getProduct().getProductName());
				count++;
			}
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			ArrayList<Account> accountList = customer.getAccountList();
			Account account = accountList.get(choice - 1);
			System.out.println("Choose the Service you want to use");
			Product product = account.getProduct();
			count = 1;
			for (Services services : product.getServicesList()) {
				System.out.println(count + "." + services.getServiceName());
				count++;
			}
			choice = scanner.nextInt();
			ArrayList<Services> servicesList = product.getServicesList();
			Services services = servicesList.get(choice - 1);
			System.out.println("Enter Number of Transactions");
			int transactionCount = scanner.nextInt();
			double rate = services.getRate() * transactionCount;
			System.out.println("Rate: " + rate);
		}
	}

	public static Account createAccount(int choice, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Product product = null;
		System.out.println("Enter account code:");
		String accountCode = scanner.nextLine();

		product = ProductConfiguration.addProduct(choice, productList);
		System.out.println("Enter opening balance to be deposisted");
		double openingBalance = scanner.nextDouble();
		if ((product instanceof SavingsAccount) == true) {
			SavingsAccount savings = (SavingsAccount) product;
			if (openingBalance < savings.getMinBalance()) {
				do {
					System.out.println("Min Balance should be atleast 1000!");
					System.out.println("Enter opening balance to be deposisted");
					openingBalance = scanner.nextDouble();
				} while (openingBalance < 1000);
			}
		}
		return new Account(accountCode, product, openingBalance);
	}
}
