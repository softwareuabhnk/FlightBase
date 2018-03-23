package se.lexicon.model;

import java.text.SimpleDateFormat;
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


	
	public int	reserveSeat(TicketType ticketType, Customer customer) {
		int reservedSeatNumber;
		
		Seat seat=null;
		if (ticketType==TicketType.ECONOMY) {

			seat=economySeats.stream().filter(e -> e.isOccupied()==false).findFirst().get();
			
		} else {
			// Business
			seat=businessSeats.stream().filter(e -> e.isOccupied()==false).findFirst().get();
			
		}

		seat.setOccupied(true);
		seat.setCustomer(customer);
		reservedSeatNumber=seat.getNumber();
//		System.out.println(seat);

		
		return reservedSeatNumber;
		
	}



	public int getFlightID() {
		return flightID;
	}



	@Override
	public String toString() {
		SimpleDateFormat departureFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
//		return "Flight [flightID=" + flightID + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
//				+ ", origin=" + origin + ", destination=" + destination + ", economySeats=" + economySeats
//				+ ", businessSeats=" + businessSeats + "]";
		return "[" + flightID + "]\t" + origin + "-" + destination + "\t\t" + departureFormat.format(departureTime) + "\t" + departureFormat.format(arrivalTime);
	}
	
	
	
	
}
