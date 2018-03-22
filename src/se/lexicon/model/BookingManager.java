package se.lexicon.model;

import java.util.Date;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class BookingManager implements BookingManagerInterface {
	
	static private Map<Integer, Customer> customerMap = new HashMap<>();
	static private Map<Integer, Flight> flightMap = new HashMap<>();
	static private Map<Integer, Ticket> ticketMap = new HashMap<>();
	
	static private double profitLevel = 30;
	
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

		//TODO Change impl to lambda?
		 
		 for (Flight nextFlight : flightMap.values()) {
			
			if (nextFlight.getFlightID() == flightID) {
				return nextFlight;
			}	
		}	
		return null;	 
	 }
	 
	 
	  public Map<Integer, Flight >getFlights() {

		  return flightMap;	 
	 }
	 
	 
	 public void cancelFlight(int flightID) {
		 flightMap.remove(flightID);
	 }
 
	
	public Customer registerCustomer (String name, String adress, String phoneNumber) {
		
		customerID++;
		Customer customer = new Customer(customerID, name, adress, phoneNumber);
		
		customerMap.put(customerID, customer);
		
		return customer;
	}
	
	public void deleteCustomer(int customerID) {
		customerMap.remove(customerID);
	}
	
	
	public Customer getCustomer (int customerID) {
		
		//TODO Change impl to lambda?
		
		for (Customer nextCustomer : customerMap.values()) {
			
			if (nextCustomer.getCustomerID() == customerID) {
				return nextCustomer;
			}	
		}	
		return null;
	}
	
	public Map<Integer, Customer> getCustomers (int customerID) {
		
		return customerMap;
	}
	
	
	public int reserveTicket(int customerID, int flightID, TicketType ticketType) {
		
		ticketID++;;
		
		Flight flight  = getFlight(flightID);
		Customer customer = getCustomer(customerID);
		
		
		int seatNumber = flight.reserveSeat(ticketType, customer);
		boolean payed = true;
		Ticket ticket = new Ticket(ticketID, customerID, flightID, seatNumber, ticketType, payed);
		 
		 ticketMap.put(flightID, ticket);
	
		return ticketID;
		
	}
	
	
	public Ticket getTicket (int ticketID) {
		
			//TODO Change impl to lambda?
		
		for (Ticket nextTicket : ticketMap.values()) {
			
			if (nextTicket.getCustomerID() == customerID) {
				return nextTicket;
			}	
		}	
		return null;
	}
	
	public void unreserveTicket(int ticketID) {
		
		//TODO unreserveSeat(flightID)
		 ticketMap.remove(ticketID);
		
	}
	

	public IntSummaryStatistics getTotalIncome() {
		
		Predicate<Ticket> payed = p -> p.isPayed();
					
		IntSummaryStatistics statistics = ticketMap.values().stream().filter(payed).collect(Collectors.summarizingInt(Ticket::getTicketPrice));
		
		return statistics;
	}
	
	public double getTotalProfit() {
		
				
		IntSummaryStatistics statistics = getTotalIncome();
		double totalProfit = statistics.getAverage() * (profitLevel/100);
		
		return totalProfit;
	}
	


}
