package se.lexicon.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import se.lexicon.exception.BusinessClassFullException;
import se.lexicon.exception.EconomyClassFullException;
import se.lexicon.exception.FlightFullException;
import se.lexicon.model.food.FoodItem;
import se.lexicon.model.food.FoodOrder;
import se.lexicon.model.food.Menu;


public class BookingManager implements BookingManagerInterface {
	
	static private Map<Integer, Customer> customerMap = new HashMap<>();
	static private Map<Integer, Flight> flightMap = new HashMap<>();
	static private Map<Integer, Ticket> ticketMap = new HashMap<>();
	
	static Menu menu = null;
	
	static private double profitLevel = 30;
	
	static private int customerID = 0;
	static private int ticketID = 0;;
	static private int flightID = 0;
	
	
	 public BookingManager() {
				  
		 //One menu is created at start of booking manager 
		 menu=new Menu();

		// One flight is created at start of bookingManager 
		 Date departureTime = new Date();
		 Date arrivalTime = new Date();
		 String origin = "Stockholm";
		 String destination = "Helsinki";
		 createFlight(departureTime, arrivalTime, origin, destination);
		 
		 // Specifically for Demo: Create 3 customers at startof bookingManager
		 
		customerID++;
		Customer customer1 = new Customer(customerID, "Mike Andersson" , "Street 21", "123 456");		
		customerMap.put(customerID, customer1);
		
		customerID++;
		Customer customer2 = new Customer(customerID, "Stan Smith" , "River 9", "111 222");		
		customerMap.put(customerID, customer2);
		
		customerID++;
		Customer customer = new Customer(customerID, "Julia Jansson" , " 21", "153 459");		
		customerMap.put(customerID, customer);
				 
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
	
	public Map<Integer, Customer> getCustomers () {
		
		return customerMap;
	}
	
	
	public int reserveTicket(int customerID, int flightID, TicketType type) throws FlightFullException {
		
		ticketID++;;
		
		Flight flight  = getFlight(flightID);
		Customer customer = getCustomer(customerID);
		
		
	  try {
		
		int seatNumber = flight.reserveSeat(type, customer);
		boolean payed = true;
		Ticket ticket = new Ticket(ticketID, customerID, flightID, seatNumber, type, payed);
		 
		ticketMap.put(flightID, ticket);
		
	   } catch (FlightFullException e) {
		      
		   if (e instanceof EconomyClassFullException) {
			   
			   	throw new EconomyClassFullException();

		   } else if (e instanceof BusinessClassFullException) {
			   
			   throw new BusinessClassFullException();

		   }
	   }		
	  return ticketID;
	}
	
	
	public Ticket getTicket (int ticketID) {
		
			//TODO Change impl to lambda?
		
		for (Ticket nextTicket : ticketMap.values()) {
			
			if (nextTicket.getTicketID() == ticketID) {
				return nextTicket;
			}	
		}	
		return null;
	}
	
	public void unreserveTicket(int ticketID) {
		
		//TODO unreserveSeat - Currently no method available 
		// Flight flight  = getFlight(flightID);
		//flight.unreserveSeat(seatNumber);
		 ticketMap.remove(ticketID);
		
	}
	
	
	public String getMenu(TicketType type) {
		
		return menu.getMenu(type);
	}
	
	
	public  void reserveFood (int ticketID, TicketType type, ArrayList<Integer> arrayItems) {
		
		// Instantiate class FoodOrder
		FoodOrder foodOrder = new FoodOrder();
			
		 for (Integer index : arrayItems) { 		
		
			 //Get food item with item index
			 FoodItem foodItem = menu.getFoodItem(type, index);
	
			 // Populate instance foodOrder with foodItems
			 foodOrder.add(foodItem);		
		}
		
		// Add instance foodOrder to ticket
		Ticket ticket = getTicket(ticketID);
		ticket.setFoodOrder(foodOrder);
		 
	}

	public IntSummaryStatistics getTotalIncome() {
		
		//TODO Calculate stats on total price
		
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
