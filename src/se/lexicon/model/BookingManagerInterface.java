package se.lexicon.model;

import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.Map;

public interface BookingManagerInterface {
	
	public Customer registerCustomer(String name, String adress, String phoneNumber);
	
	public Customer getCustomer(int customerID);
	
	public Map<Integer, Customer> getCustomers();
	
	public int reserveTicket(int customerID, int flightID, TicketType ticket);
	
	public void unreserveTicket(int ticketID);
	
	public Ticket getTicket(int ticketID);
	
	public int createFlight(Date departureTime, Date arrivalTime, String origin, String destination );
	
	public Flight getFlight(int flightID);
	
	public void cancelFlight(int flightID);
	
	public Map<Integer, Flight> getFlights();
	
	public IntSummaryStatistics getTotalIncome();
	
	public double getTotalProfit();

}

 