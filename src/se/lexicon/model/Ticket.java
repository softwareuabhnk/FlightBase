package se.lexicon.model;

public class Ticket {

	private int customerID;
	private int flightID;
	private int seatNumber;
	private TicketType ticketType;
	private boolean payed;
	private int ticketPrice;
	
	

	public Ticket(int customerID, int flightID, int seatNumber, TicketType ticketType, boolean payed, int ticketPrice) {
		super();
		this.customerID = customerID;
		this.flightID = flightID;
		this.seatNumber = seatNumber;
		this.ticketType = ticketType;
		this.payed = payed;
		this.ticketPrice = ticketPrice;
		
		if (ticketType==TicketType.ECONOMY) {
			this.ticketPrice=5000;
		} else {	
			this.ticketPrice=20000;
		}
	}

	public int getCustomerID() {
		return customerID;
	}

	
	public int getFlightID() {
		return flightID;
	}

	
	public int getSeatNumber() {
		return seatNumber;
	}

	
	public TicketType getTicketType() {
		return ticketType;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}


	public int getTicketPrice() {
		return ticketPrice;
	}

	@Override
	public String toString() {
		return "Ticket [customerID=" + customerID + ", flightID=" + flightID + ", seatNumber=" + seatNumber
				+ ", ticketType=" + ticketType + ", payed=" + payed + ", ticketPrice=" + ticketPrice + "]";
	}

	
	
	
}
