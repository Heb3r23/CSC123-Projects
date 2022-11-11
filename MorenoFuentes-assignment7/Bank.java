//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

import java.util.ArrayList;

public class Bank {
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static SavingsAccount openSavingsAccount(String firstName, String lastName, String ssn) {
		Customer c = new Customer(firstName, lastName, ssn);
		SavingsAccount a = new SavingsAccount(c);
		accounts.add(a);
		return a;
	}
	
	public static CheckingAccount openCheckingAccount(String firstName, String lastName, String ssn, double overdraftLimit) {
		Customer c = new Customer(firstName, lastName, ssn);
		CheckingAccount a = new CheckingAccount(c, overdraftLimit);
		accounts.add(a);
		return a;
	}
	
	public static CreditCardAccount openCreditCardAccount(String firstName, String lastName, String ssn, double creditLimit) {
		Customer c = new Customer(firstName, lastName, ssn);
		CreditCardAccount a = new CreditCardAccount(c, creditLimit);
		accounts.add(a);
		return a;
	}
	
	public static Account lookup(int n) {
		for (Account a: accounts) {
			if(a.getAccountNumber() == n) {
				return a;
			}
		}
		return null;
	}
	
	public static void listAccounts() {
		for(Account a: accounts) {
			System.out.println(a);
		}
	}
	
	public static int numberOfAccounts() {
		return accounts.size();
	}
}
