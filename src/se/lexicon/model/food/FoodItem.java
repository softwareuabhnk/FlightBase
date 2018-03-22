package se.lexicon.model.food;

public class FoodItem {
	private	String	description;
	private	int		price;
	
	
	
	public FoodItem(String description, int price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return description + " " + price + " kr";
	}
	
	
}
