package se.lexicon.model;

import java.util.Map;


public class BookingManager implements BookingManagerInterface {
	
	static private Map<Integer, Customer> customerMap;
	//static private map<Integer, Flight> flightMap
	static private map<Integer, Ticket> ticketMap;
	
	 static private int customerID = 0;
	 static private int ticketID = 0;;
	 static private int flightID = 0;
	
	
	 public BookingManager() {
		 
		 // One flight is created at start of bookingManager
		 createFlight();
	 }
	 
	 public int createFlight() {
		 
		 flightID++;
		 
		 //Flight flight = new Flight(int flightID .......);
		 //flightMap.put(flightID, flight);
		 
		 return flightID;
	 }	
	 
	 public void getfligth(int flightID) {
		 
	 }
	 
	 
	 public void cancelFligth(int flightID) {
		 //flightmap.remove(flightID);
	 }

	 
	
	public int registerCustomer (String name, String adress, String phoneNumber) {
		
		customerID++;
		Customer customer = new Customer(customerID, name, adress, phoneNumber);
		
		customerMap.put(customerID, customer);
		
		return customerID;
	}
	
	public void deleteCustomer(int customerID) {
		customerMap.remove(customerID);
	}
	
	
	public Customer getCustomer (int customerID) {
		
		for (Customer nextCustomer : customerMap.values()) {
			
			if (nextCustomer.getCustomerID() == customerID) {
				return nextCustomer;
			}	
		}	
		return null;
	}
	
	public int reserveTicket(int customerID, int flightID, TicketType ticket) {
		
		ticketID++;;
		
		//int seatNumber = flight.reserveSeat(ticket);
		int seatNumber = 5;
		//int booking = new Booking(......);
		
		return ticketID;
		
	}
	
	public void unreserveBooking(int bookingID) {
		
		//remove from bookingMap
		//unreserveSeat(flightID)
		
	}
	
	public void getBooking(int bookingID) {
		
		//bookingMap.get(bookingID)
		
		//return booking	
	}	
	



}
