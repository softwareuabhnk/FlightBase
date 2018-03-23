package se.lexicon.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import se.lexicon.model.Ticket;
import se.lexicon.model.TicketType;

public class TicketTest {

	@Test
	public void test() {

		Ticket t=new Ticket(2,1,234,5,TicketType.BUSINESS,false);
	
		assertEquals("Ticket [customerID=1, flightID=234, seatNumber=5, ticketType=BUSINESS, payed=false, ticketPrice=20000]", t.toString());
	}

}
