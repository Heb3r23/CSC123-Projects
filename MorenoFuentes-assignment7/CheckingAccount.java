//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

public class CheckingAccount extends Account{
	private double overdraftLimit;
	
	public CheckingAccount(Customer c, double overdraftLimit) {
		super("Checking Account", c);
		this.overdraftLimit = overdraftLimit;
	}
	
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	
	//Overridden Methods

	@Override
	public boolean deposit(double amount) {
		if(!isOpen())
			return false;
		return super.deposit(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		if(((overdraftLimit - amount)+getBalance()) < 0.00) {
			return false;
		}
		return super.withdraw(amount);
	}
}
