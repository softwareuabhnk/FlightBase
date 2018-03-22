package se.lexicon.model.food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodOrder {
	private List<FoodItem>	items = new ArrayList<>();
	
	public FoodOrder() {
		super();
	}

	public void add(FoodItem foodItem) {
		items.add(foodItem);
	}

	public int getTotal() {
		int total=items.stream().collect(Collectors.summingInt(e -> e.getPrice()));
	
		return total;
	}
	
}
