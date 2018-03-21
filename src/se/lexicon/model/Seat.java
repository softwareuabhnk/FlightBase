package se.lexicon.model;

public class Seat {

	private int number;
	private boolean occupied;
	
	public Seat(int number) {
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + ", occupied=" + occupied + "]";
	}

}
