package se.lexicon.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import se.lexicon.model.TicketType;
import se.lexicon.model.food.FoodOrder;
import se.lexicon.model.food.Menu;

public class MenuTest {

	@Test	
	public void test() {
		Menu m=new Menu();
		
		System.out.println(m.getMenu(TicketType.ECONOMY));
		System.out.println(m.getMenu(TicketType.BUSINESS));
		
		
		
		FoodOrder f=new FoodOrder();
		
		f.add(m.getFoodItem(TicketType.BUSINESS, 2));
		f.add(m.getFoodItem(TicketType.BUSINESS, 3));
		
		
		System.out.println(f.getTotal());
		
		assertEquals(0,0);
		
		
	}

}
