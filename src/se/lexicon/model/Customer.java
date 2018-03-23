package se.lexicon.model;

public class Customer {
	private int customerID;
	private String name;
	private String adress;
	private String phoneNumber;
	
	

	public Customer(int customerID, String name, String adress, String phoneNumber) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}

	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerid) {
		this.customerID = customerid;
	}
	
	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	@Override
	public String toString() {
		return "Customer ID: " + customerID
				+ "\nname: " + name
				+ "\nadress: " + adress
				+ "\nphone: " + phoneNumber;
	}
	
	
}
