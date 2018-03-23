package se.lexicon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import se.lexicon.exception.FlightFullException;

public interface BookingManagerInterface {
	
	public Customer registerCustomer(String name, String adress, String phoneNumber);
	
	public Customer getCustomer(int customerID);
	
	public Map<Integer, Customer> getCustomers();
	
	public int reserveTicket(int customerID, int flightID, TicketType type) throws FlightFullException;
	
	public void unreserveTicket(int ticketID);
	
	public Ticket getTicket(int ticketID);
	
	public int createFlight(Date departureTime, Date arrivalTime, String origin, String destination );
	
	public Flight getFlight(int flightID);
	
	public void cancelFlight(int flightID);
	
	public Map<Integer, Flight> getFlights();
	
	public IntSummaryStatistics getTotalIncome();
	
	public double getTotalProfit();
	
	public String getMenu(TicketType type);
	
	public void reserveFood (int ticketID, TicketType type, ArrayList<Integer> arrayItems);

}

 