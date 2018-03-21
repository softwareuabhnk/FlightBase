package se.lexicon.model;

public interface FlightInterface {

		public int	reserveSeat(TicketType ticketType, Customer customer);
		public int	getFlightID();
}
