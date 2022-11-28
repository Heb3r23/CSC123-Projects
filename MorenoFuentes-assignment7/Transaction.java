//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

import java.io.Serializable;

public class Transaction implements Serializable{
	private static final long serialNumberUID = 1L;
	private static int transactionIdCounter = 100000;
	
	private int transactionID;
	private String transactionType;
	private double amount;
	
	public Transaction(String type, double amt) {
		transactionType = type;
		amount = amt;
		transactionID = ++transactionIdCounter;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString() {
		return transactionID + " : " + transactionType + " : " + amount;
	}
}
