package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Services;

public class ProductConfiguration {

	public static Product createProduct(ArrayList<Services> serviceList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Savings Account");
		System.out.println("2.Current Account");
		System.out.println("3.Loan Account");
		System.out.println("Choose the type of account:");
		int choice = scanner.nextInt();
		System.out.println("Enter Product Code:");
		String productCode = scanner.next();
		ArrayList<Services> servicesIncludedList = new ArrayList<Services>();
		char addMoreService;
		do {
			System.out.println("Choose the Service you want to use");
			int count = 1;
			for (Services services : serviceList) {
				System.out.println(count + "." + services.getServiceName());
				count++;
			}
			int serviceChoice = scanner.nextInt();
			servicesIncludedList.add(serviceList.get(serviceChoice - 1));
			System.out.println("Do you want to add more Service (y/n)");
			addMoreService = scanner.next().charAt(0);
		} while (addMoreService == 'y');
		Product product = null;
		switch (choice) {
		case 1: {
			System.out.println("Minimum Balance is set to 1000rs");
			String productName = "Savings Account";
			product = new SavingsAccount(productCode, productName, servicesIncludedList, 1000);
			break;

		}
		case 2: {
			String productName = "Current Account";
			product = new CurrentAccount(productCode, productName, servicesIncludedList);
			break;
		}
		case 3: {
			String productName = "Loan Account";
			product = new LoanAccount(productCode, productName, servicesIncludedList);
			break;
		}
		}
		return product;

	}

	public static Services createService() {
		char addMoreService;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Service Code:");
		String serviceCode = scanner.next();
		System.out.println("Enter Service Name:");
		String serviceName = scanner.next();
		System.out.println("Enter Service Rate:");
		double serviceRate = scanner.nextDouble();
		Services service = new Services(serviceCode, serviceName, serviceRate);
		return service;
	}

	public static Product addProduct(int choice, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Product product = productList.get(choice - 1);
		return product;

	}

}
