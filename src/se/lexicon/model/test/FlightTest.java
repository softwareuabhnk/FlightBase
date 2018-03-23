package se.lexicon.model.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import se.lexicon.exception.BusinessClassFullException;
import se.lexicon.exception.EconomyClassFullException;
import se.lexicon.exception.FlightFullException;
import se.lexicon.model.Customer;
import se.lexicon.model.Flight;
import se.lexicon.model.TicketType;

public class FlightTest {

	@Test
	public void test() {
		Flight f = new Flight(1, new Date(), new Date(), "Stockholm", "New York");
		Customer c1 = new Customer(1, "Olle Karlsson1", "Grevgatan 3...V�xj�", "0731231234");
		Customer c2 = new Customer(102, "Olle Karlsson2", "Grevgatan 3...V�xj�", "0731231234");
		Customer c3 = new Customer(103, "Olle Karlsson3", "Grevgatan 3...V�xj�", "0731231234");
		Customer c4 = new Customer(204, "Olle Karlsson4", "Grevgatan 3...V�xj�", "0731231234");
		Customer c5 = new Customer(205, "Olle Karlsson5", "Grevgatan 3...V�xj�", "0731231234");
		Customer c6 = new Customer(206, "Olle Karlsson6", "Grevgatan 3...V�xj�", "0731231234");
		Customer c7 = new Customer(207, "Olle Karlsson7", "Grevgatan 3...V�xj�", "0731231234");
System.out.println(c7);
		try {
			assertEquals(1, f.reserveSeat(TicketType.ECONOMY, c1));
			assertEquals(2, f.reserveSeat(TicketType.ECONOMY, c2));
			assertEquals(3, f.reserveSeat(TicketType.ECONOMY, c3));
			assertEquals(6, f.reserveSeat(TicketType.BUSINESS, c4));
			assertEquals(7, f.reserveSeat(TicketType.BUSINESS, c5));
			assertEquals(4, f.reserveSeat(TicketType.ECONOMY, c6));
			assertEquals(1, f.getFreeSeats(TicketType.ECONOMY));
			assertEquals(5, f.reserveSeat(TicketType.ECONOMY, c7));
		} catch (FlightFullException e) {
			// TODO: handle exception
			fail("full when not full");

		}

		assertEquals(0, f.getFreeSeats(TicketType.ECONOMY));
		assertEquals(3, f.getFreeSeats(TicketType.BUSINESS));
		try {
			assertEquals(8, f.reserveSeat(TicketType.ECONOMY, c7));
		} catch (FlightFullException e) {
			if (e instanceof EconomyClassFullException) {

				System.out.println("Economy Class Full");

			} else if (e instanceof BusinessClassFullException) {

				System.out.println("Business Class Full");
			}

		}
	}

}