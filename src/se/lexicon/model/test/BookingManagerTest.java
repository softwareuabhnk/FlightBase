package se.lexicon.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import se.lexicon.model.BookingManager;
import se.lexicon.model.Flight;

public class BookingManagerTest {
	
	
	
		@Test
		public void testCreateFlight() {
			
			int flightID;
			
			Date departureTime = new Date();
			Date arrivalTime = new Date();
			String origin = "Stokholm";
			String destination = "Helsinki";
			
			BookingManager bc = new BookingManager();
			
			flightID = bc.createFlight(departureTime, arrivalTime, origin, destination );
				
			assertEquals(flightID, 1 + 1);
		
			System.out.println(flightID);

		}
		
		@Test
		public void tesGetFlightID() {
		
			int flightID = 2;
			
			BookingManager bc = new BookingManager();
		
			Flight flight = bc.getFlight(flightID);
			
			assertEquals(flight.getFlightID(), 1 + 1);
	
			System.out.println(flightID);

	}
		
		
}
		
