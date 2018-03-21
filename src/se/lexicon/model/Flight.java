package se.lexicon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import se.lexicon.model.TicketType;

public class Flight implements FlightInterface {
	
	
	int flightID;
	
	
	Date departureTime;
	Date arrivalTime;
	String origin;
	String destination;
	

	List <Seat> economySeats=new ArrayList<Seat>(5);
	List <Seat> businessSeats=new ArrayList<Seat>(5);
	
	
	public Flight(int flightID, Date departureTime, Date arrivalTime, String origin, String destination) {
		super();
		this.flightID = flightID;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		
				
		// Seats 1-5  Economy
		for (int seatNumber=1; seatNumber<=5; seatNumber++) {
			economySeats.add(new Seat(seatNumber));
		}
		
		// Seats 6-10 Business
		for (int seatNumber=6; seatNumber<=10; seatNumber++) {
			businessSeats.add(new Seat(seatNumber));
		}
		
	}


	
	public int	reserveSeat(TicketType ticketType) {
		int reservedSeatNumber;
		
		Seat seat=null;
		if (ticketType==TicketType.ECONOMY) {

			seat=economySeats.stream().filter(e -> e.isOccupied()==false).findFirst().get();
			
		} else {
			// Business
			seat=businessSeats.stream().filter(e -> e.isOccupied()==false).findFirst().get();
			
		}
		
		reservedSeatNumber=seat.getNumber();
		seat.setOccupied(true);
		System.out.println(seat);

		
		return reservedSeatNumber;
		
	}
	
	
	
	
}
