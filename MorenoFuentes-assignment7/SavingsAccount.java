//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

public class SavingsAccount extends Account{
	
	public SavingsAccount(Customer accountHolder) {
		super("Savings Account", accountHolder);
	}

	
	//Overridden Methods
	
	@Override
	public boolean deposit(double amount) {
		if(isOpen() && amount > 0) {
			return super.deposit(amount);
		}
		else
			return false;
	}

	@Override
	public boolean withdraw(double amount) {
		if(getBalance()-amount > 0 && amount > 0) {
			return super.withdraw(amount);
		}
		else
			return false;
			
	}
	
	
}
