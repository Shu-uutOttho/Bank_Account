package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();

		account acc = new account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		try {
			acc.withdray(amount);
			System.out.printf("New Balance: %2F%n", acc.getBalance());
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		} 

		sc.close();
	}

}
