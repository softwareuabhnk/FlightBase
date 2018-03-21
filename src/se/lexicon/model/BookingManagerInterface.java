package se.lexicon.model;

public interface BookingManagerInterface {
	
	public int registerCustomer(String name, String adress, String phoneNumber);
	
	public Customer getCustomer(int customerID);
	
	public int reserveTicket(int customerID, int flightID, TicketType ticket);

}

 