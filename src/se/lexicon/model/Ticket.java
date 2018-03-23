package se.lexicon.model;

import se.lexicon.model.food.FoodOrder;

public class Ticket {

	private int ticketID;
	private int customerID;
	private int flightID;
	private int seatNumber;
	private TicketType ticketType;
	private boolean payed;
	private int ticketPrice;
	private FoodOrder foodOrder;
	

	public Ticket(int ticketID, int customerID, int flightID, int seatNumber, TicketType ticketType, boolean payed) {
		super();
		this.ticketID = ticketID;
		this.customerID = customerID;
		this.flightID = flightID;
		this.seatNumber = seatNumber;
		this.ticketType = ticketType;
		this.payed = payed;
		
		if (ticketType==TicketType.ECONOMY) {
			this.ticketPrice=5000;
		} else {	
			this.ticketPrice=20000;
		}
	}


	public int getTicketID() {
		return ticketID;
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


	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}


	public int getTicketPrice() {
		return ticketPrice+foodOrder.getTotal();
	}


	@Override
	public String toString() {
		return "Ticket ID:\t\t" + ticketID
				+ "\ncustomer ID:\t" + customerID
				+ "\nflight ID:\t\t" + flightID
				+ "\nseatNumber:\t" + seatNumber
				+ "\ntype:\t\t\t" + (ticketType==TicketType.BUSINESS ? "Business Class" : "Economy Class")
				+ "\npayed:\t\t" + (payed==true ? "Yes" : "No")
				+ "\ntotal:\t\t" + getTicketPrice()
				+ "\nfood:\t\t" + (foodOrder!=null ? "Food reserved" : "No food reserved");
	}



	
}
