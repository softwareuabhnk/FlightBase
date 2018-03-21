package se.lexicon.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BookingManager implements BookingManagerInterface {
	
	static private Map<Integer, Customer> customerMap = new HashMap<>();
	static private Map<Integer, Flight> flightMap = new HashMap<>();
	static private Map<Integer, Ticket> ticketMap = new HashMap<>();
	
	 static private int customerID = 0;
	 static private int ticketID = 0;;
	 static private int flightID = 0;
	
	
	 public BookingManager() {
		 
		 // One flight is created at start of bookingManager
		 
		 Date departureTime = new Date();
		 Date arrivalTime = new Date();
		 String origin = "Stockholm";
		 String destination = "Helsinki";
		 createFlight(departureTime, arrivalTime, origin, destination);
	 }
	 
	 public int createFlight(Date departureTime, Date arrivalTime, String origin, String destination ) {
		 
		 flightID++;	
		 
		 Flight flight = new Flight(flightID, departureTime, arrivalTime, origin, destination);
		 
		 flightMap.put(flightID, flight);
		 
		 return flightID;
	 }	
	 
	 public Flight getFlight(int flightID) {
		 
		 for (Flight nextFlight : flightMap.values()) {
			
			if (nextFlight.getFlightID() == flightID) {
				return nextFlight;
			}	
		}	
		return null;	 
	 }
	  
	 public void cancelFligth(int flightID) {
		 flightMap.remove(flightID);
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
	
	public int reserveTicket(int customerID, int flightID, TicketType ticketType) {
		
		ticketID++;;
		
		//int seatNumber = flight.reserveSeat(ticket);
		boolean payed = false;
		int seatNumber = 5;
		 Ticket ticket = new Ticket(ticketID, customerID, flightID, seatNumber, ticketType, payed);
		 
		 ticketMap.put(flightID, ticket);
	
		return ticketID;
		
	}
	
	public void unreserveTicket(int ticketID) {
		
		//remove from bookingMap
		//unreserveSeat(flightID)
		 ticketMap.remove(ticketID);
		
	}
	
	public Ticket getTicket(int ticketID) {
		
		for (Ticket nextTicket : ticketMap.values()) {
			
			if (nextTicket.getTicketID() == ticketID) {
				return nextTicket;
			}	
		}	
		return null;
		
	}	
}
