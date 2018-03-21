package se.lexicon.model;

public interface BookingManagerInterface {
	
	public int registerCustomer(String name, String address, String phoneNumber);
	
	public int reserveBooking(int customerID, int flightID, TicketType ticket);

}

