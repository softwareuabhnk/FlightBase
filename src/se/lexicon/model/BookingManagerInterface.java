package se.lexicon.model;

public interface BookingManagerInterface {
	
	public int registerCustomer(String Name, String address, String phoneNumber);
	public int registerBooking(int CustomerID, int flightID, TicketType ticket);

}

