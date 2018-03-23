package se.lexicon.model;

import se.lexicon.exception.FlightFullException;

public interface FlightInterface {

	public int reserveSeat(TicketType ticketType, Customer customer) throws FlightFullException;

	public int getFlightID();
}
