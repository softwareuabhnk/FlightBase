package se.lexicon.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import se.lexicon.model.Ticket;
import se.lexicon.model.TicketType;

public class TicketTest {

	@Test
	public void test() {

		Ticket t=new Ticket(111, 1,234,5,TicketType.BUSINESS,false);
		System.out.println(t);
		assertEquals("Ticket [ticketID=111, customerID=1, flightID=234, seatNumber=5, ticketType=BUSINESS, payed=false, ticketPrice=20000]", t.toString());
	}

}
