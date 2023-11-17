package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Services;

public class AccountConfiguration {
	public static void manageAccount(Customer customer, String customerId) {
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
			String serviceName = services.getServiceName();

			if (serviceName.equalsIgnoreCase("CashDeposit")) {
				System.out.println("Enter the amount to be deposited:");
				double deposit = scanner.nextDouble();
				double balance = account.getAccountBalance() + deposit;
				account.setAccountBalance(balance);
			}
			if (serviceName.equalsIgnoreCase("ATMWithdrawal")) {
				System.out.println("Enter the amount to be withdrawn:");
				double withdraw = checkSavingsAccount(product, account);
				account.setAccountBalance(account.getAccountBalance() - withdraw);
			}
			if (serviceName.equalsIgnoreCase("OnlineBanking")) {
				System.out.println("Enter the amount to transfered:");
				double transferAmount = checkSavingsAccount(product, account);
				double rate = services.getRate();
				double transferBalance = account.getAccountBalance()
						- (transferAmount + (rate / 100) * account.getAccountBalance());
				System.out.println("Balance after reducing " + rate + "% service fee:" + transferBalance);
				account.setAccountBalance(transferBalance);
			}
			if (serviceName.equalsIgnoreCase("MobileBanking")) {
				System.out.println("Enter the amount to transfered:");
				double transferAmount = checkSavingsAccount(product, account);
				double rate = services.getRate();
				double transferBalance = account.getAccountBalance()
						- (transferAmount + (rate / 100) * account.getAccountBalance());
				System.out.println("Balance after reducing " + rate + "% service fee:" + transferBalance);
				account.setAccountBalance(transferBalance);
			}
			if (serviceName.equalsIgnoreCase("ChequeDeposit")) {
				System.out.println("Enter the amount to transfered:");
				double transferAmount = checkSavingsAccount(product, account);
				double rate = services.getRate();
				double transferBalance = account.getAccountBalance()
						- (transferAmount + (rate / 100) * account.getAccountBalance());
				System.out.println("Balance after reducing " + rate + "% service fee:" + transferBalance);
				account.setAccountBalance(transferBalance);
			}

		}
	}

	public static double checkSavingsAccount(Product product, Account account) {

		Scanner scanner = new Scanner(System.in);
		double withdraw = scanner.nextDouble();
		if ((product instanceof SavingsAccount) == true) {
			SavingsAccount savings = (SavingsAccount) product;
			if ((account.getAccountBalance() - withdraw) < savings.getMinBalance()) {
				do {
					System.out.println("Can't Withdraw that much! Min Balance should be atleast 1000.");
					System.out.println("Enter the amount to be withdrawn:");
					withdraw = scanner.nextDouble();
				} while ((account.getAccountBalance() - withdraw) < 1000);
			}

		}
		return withdraw;
	}

}
