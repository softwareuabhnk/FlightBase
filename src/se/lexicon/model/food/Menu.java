package se.lexicon.model.food;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.model.TicketType;

public class Menu {
	private List<FoodItem>	economyItems = new ArrayList<>();
	private List<FoodItem>	businessItems = new ArrayList<>();
	
	
	
	public Menu() {
		super();
		economyItems.add(new FoodItem("Fish and Chips", 72));
		economyItems.add(new FoodItem("Hamburger w Pommes Frites", 68));

		businessItems.add(new FoodItem("Hamburger w Pommes Frites", 101));
		businessItems.add(new FoodItem("Filet Mignon", 112));
		businessItems.add(new FoodItem("Caviar and Champagne", 911));

		
		
	}

	public String getMenu(TicketType type) {
		StringBuilder sb=new StringBuilder();

		if (type==TicketType.ECONOMY) {
		
			for ( int i=0; i<economyItems.size(); i++ ) {
				sb.append(Integer.toString(i+1));
				sb.append(" "+economyItems.get(i).getDescription()+" ");
				sb.append(economyItems.get(i).getPrice()+" kr\n");			
			}
		} else {
			for ( int i=0; i<businessItems.size(); i++ ) {
				sb.append(Integer.toString(i+1));
				sb.append(" "+businessItems.get(i).getDescription()+" ");
				sb.append(businessItems.get(i).getPrice()+" kr\n");			
			}			
		}
		sb.append("\nDrinks included");
		
		return sb.toString();
	}
	
	public FoodItem getFoodItem(TicketType type, int index) {
		
		index--;  // adjust index to start at zero.
		
		if (type==TicketType.ECONOMY) {
			return (economyItems.get(index));
		} else {
			return (businessItems.get(index));
		}
 
	}


	
}
