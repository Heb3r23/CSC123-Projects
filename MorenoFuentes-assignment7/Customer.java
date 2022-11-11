//Heber Moreno Fuentes (hmorenofuentes1@toromail.csudh.edu

public class Customer {
	private String firstName;
	private String lastName;
	private String ssn;
	
	public Customer(String fName, String lName, String ssn) {
		setFirstName(fName);
		setLastName(lName);
		setSSN(ssn);
	}
	public Customer() {
		
	}

	public void setFirstName(String a){
		firstName = a;
	}
	public String getFisrtName(){
		return firstName;
	}

	public void setLastName(String b){
		lastName = b;
	}
	public String getLastName(){
		return lastName;
	}

	public void setSSN(String c){
		ssn = c;
	}
	public String getSSN(){
		return ssn;
	}
	
	@Override
	public String toString(){
		String ret = (firstName + " : " + lastName + " : " + ssn);
		return (ret);
	}
	public boolean equals() {
		return true;
	}
	


}
