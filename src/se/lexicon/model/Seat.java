package se.lexicon.model;

public class Seat {

	private int number;
	private Customer customer;
	private boolean occupied;
	
	public Seat(int number) {
		this.number=number;
	}

	public int getNumber() {
		return number;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + ", customer=" + customer + ", occupied=" + occupied + "]";
	}


}
