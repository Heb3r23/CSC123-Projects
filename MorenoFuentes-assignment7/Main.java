//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menuSelection = 0;
		int lookupNumber = 0;
		double depositAmount = 0.0;
		double withdrawalAmount = 0;
		String tempFName;
		String tempLName;
		String tempSocial;
		double tempOverdraft;
		double tempCredit;
		
		Bank mainBank = new Bank();
		
		while(menuSelection != 9) {
			printMenu();
			menuSelection = input.nextInt();
			input.nextLine();
			
			if(menuSelection == 1) {
				System.out.println("Enter first name: ");
				tempFName = input.nextLine();
				System.out.println("Enter last name: ");
				tempLName = input.nextLine();
				System.out.println("Enter social security number: ");
				tempSocial = input.nextLine();
				System.out.println("Enter overdraft limit: ");
				tempOverdraft = input.nextDouble();
				
				Bank.openCheckingAccount(tempFName, tempLName, tempSocial, tempOverdraft);
				System.out.println("Thank you, the account number is " + Bank.lookup(1000+Bank.numberOfAccounts()).getAccountNumber());
			}
			else if(menuSelection == 2) {
				System.out.println("Enter first name: ");
				tempFName = input.nextLine();
				System.out.println("Enter last name: ");
				tempLName = input.nextLine();
				System.out.println("Enter social security number: ");
				tempSocial = input.nextLine();
				
				Bank.openSavingsAccount(tempFName, tempLName, tempSocial);
				System.out.println("Thank you, the account number is " + Bank.lookup(1000+Bank.numberOfAccounts()).getAccountNumber());
			}
			else if(menuSelection == 3) {
				System.out.println("Enter first name: ");
				tempFName = input.nextLine();
				System.out.println("Enter last name: ");
				tempLName = input.nextLine();
				System.out.println("Enter social security number: ");
				tempSocial = input.nextLine();
				System.out.println("Enter credit limit: ");
				tempCredit = input.nextDouble();
				
				Bank.openCreditCardAccount(tempFName, tempLName, tempSocial, tempCredit);
				System.out.println("Thank you, the account number is " + Bank.lookup(1000+Bank.numberOfAccounts()).getAccountNumber());
			}
			else if(menuSelection == 4) {
				Bank.listAccounts();
			}
			else if(menuSelection == 5) {
				boolean check = true;
				System.out.println("Enter account number: ");
				lookupNumber = input.nextInt();
				
				Account a = Bank.lookup(lookupNumber);
				
				if(a == null) {
					System.out.println("Account not found");
				}
				else {
					a.printStatement(check);
				}
				
			}
			else if(menuSelection == 6) {
				System.out.println("Enter account number: ");
				lookupNumber = input.nextInt();
				System.out.println("Enter the amount to deposit: ");
				depositAmount = input.nextDouble();
				
				Account a = Bank.lookup(lookupNumber);
				
				if(a == null) {
					System.out.println("Account not found");
				}
				else if(a.deposit(depositAmount)) {
					System.out.printf("Deposit successful, the new balance is : %.2f", a.getBalance());
				}
				else {
					System.out.printf("Deposit failed, the balance is: %.2f", a.getBalance());
				}
				
				
			}
			else if(menuSelection == 7) {
				System.out.println("Enter account number: ");
				lookupNumber = input.nextInt();
				System.out.println("Enter the withdrawal amount: ");
				withdrawalAmount = input.nextDouble();
				
				Account a = Bank.lookup(lookupNumber);
				
				if(a == null) {
					System.out.println("Account not found");
				}
				else if(a.withdraw(withdrawalAmount)) {
					System.out.printf("Withdrawal successful, the new balance is : %.2f", a.getBalance());
				}
				else {
					System.out.printf("Withdrawal failed, the balance is: %.2f", a.getBalance());
				}
				
				
			}
			else if(menuSelection == 8) {
				System.out.println("Enter account number to close: ");
				lookupNumber = input.nextInt();
				Account a = Bank.lookup(lookupNumber);
				
				if(a == null) {
					System.out.println("Account not found");
				}
				else {
					a.close();
					System.out.printf("Account closed, current balance is %.2f, deposits are no longer possible", a.getBalance());
				}
			}
			else if(menuSelection == 9) {
				try {
					printFile();
				}
				catch (IOException ex) {
					System.out.println("Error: file not created");
					System.exit(0);
				}
				
				System.exit(0);
			}
		}
		
		
		
	}
	
	public static void printMenu() {
		System.out.println("\n\n1 - Open Checking Account \n2 - Open Saving Accounts \n3 - Open Credit Card Account \n4 - List Accounts \n5 - Account Statement \n6 - Deposit Funds \n7 - Withdraw Funds \n8 - Close an Account \n9 - Exit \nPlease enter your choice:");
	}
	
	public static void printFile() throws IOException {
		
		PrintWriter p = new PrintWriter("Receipt");
		p.write(printAllStatements());
		p.close();

	}
	
	public static String printAllStatements() {
		boolean check = false;
		int lookupNumber = 1001;
		String ret = "";
		
		Account a = Bank.lookup(lookupNumber);
		
		ret += ("Customer List: \n\n");
		while(a!=null) {
			ret+=(a.getAccountHolder());
			ret+="\n";
			lookupNumber++;
			a = Bank.lookup(lookupNumber);
		}
		
		lookupNumber = 1001;
		a = Bank.lookup(lookupNumber);
		
		ret += ("\n\nAccount List:  \n\n");
		while(a!=null) {
			ret+=(a);
			ret += "\n";
			lookupNumber++;
			a = Bank.lookup(lookupNumber);
		}
		
		lookupNumber = 1001;
		a = Bank.lookup(lookupNumber);
		
		ret += ("\n\nTransaction Statements: \n\n");
		while(a!=null) {
			ret += ("Transaction Statement for Account " + a.getAccountNumber() + ":\n\n");
			ret+=(a.printStatement(check));
			lookupNumber++;
			a = Bank.lookup(lookupNumber);
		}
		
		return ret;
	}
}
