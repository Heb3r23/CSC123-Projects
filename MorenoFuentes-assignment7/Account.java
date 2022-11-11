//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

import java.util.ArrayList;

public abstract class Account {
	private static int accountNumberCounter = 1000;
	
	private String accountName;
	private Customer accountHolder;
	private boolean open = true;
	private int accountNumber;
	private ArrayList <Transaction>transactions = new ArrayList<Transaction>();
	
	
	protected Account(String name, Customer customer) {
		accountName = name;
		accountHolder = customer;
		accountNumber = ++accountNumberCounter;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		double returnBalance = 0;
		for(Transaction a: transactions) {
			returnBalance += a.getAmount();
		}
		return returnBalance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean deposit(double amount) {
			Transaction a = new Transaction("Credit", amount);
			transactions.add(a);
			
			//balance += amount;
			return true;
	}
	public boolean withdraw(double amount) {
			Transaction a = new Transaction("Debit", -amount);
			transactions.add(a);
		
			//balance -= amount;
			return true;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void printStatement() {
		for(Transaction b: getTransactions()) {
			System.out.println(b.toString());
		}
	}
	
	public void close() {
		open = false;
	}
	public boolean isOpen() {
		return open;
	}
	
	@Override
	public String toString() {
		String aName = accountNumber + " : (" + accountName + ") : " + accountHolder.toString() + " : " + String.format("%.2f", getBalance()) + " : " + (open?"Account Open":"Account Closed");
		return aName;
	}
}
