//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

public class CreditCardAccount extends Account{
	
	private double creditLimit;
	
	public CreditCardAccount(Customer c, double creditLimit) {
		super("Credit Card", c);
		this.creditLimit = creditLimit;
	}

	
	//Overridden Methods
	
	@Override
	public boolean deposit(double amount) {
		return super.withdraw(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		if(getBalance()+amount > creditLimit)
			return false;
		return super.deposit(amount);
	}
	
	

}
