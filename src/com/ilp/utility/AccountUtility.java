package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.CustomerConfiguration;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customer = null;
		ArrayList<Services> servicesList = new ArrayList<Services>();
		ArrayList<Product> productList = new ArrayList<Product>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Welcome To Bank************");
		char goToMainMenu;
		do {
			System.out.println(
					"1.Create Services 2.Create Product 3.Create Accounts 4.Display Accounts 5.Manage Account 6.Transaction Bill");
			int mainMenuChoice = scanner.nextInt();
			switch (mainMenuChoice) {
			case 1:
				servicesList.add(ProductConfiguration.createService());
				break;
			case 2:
				productList.add(ProductConfiguration.createProduct(servicesList));
				break;
			case 3:
				customer = CustomerConfiguration.createCustomer(customer, productList);
				break;
			case 4:
				CustomerConfiguration.displayCustomer(customer);
				break;
			case 5:
				System.out.println("Enter the customer Id:");
				String customerId = scanner.next();
				AccountConfiguration.manageAccount(customer, customerId);
				break;
			case 6:
				System.out.println("Enter the customer Id:");
				customerId = scanner.next();
				CustomerConfiguration.transactionBill(customer, customerId);
				break;
			}
			System.out.println("Go back to main menu (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		} while (goToMainMenu == 'y');
	}

}
