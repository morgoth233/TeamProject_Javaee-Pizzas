package consumable;

import java.util.Set;

public class Dessert extends Consumable{
	
	private boolean iceCream;
	
	public Dessert(String name, double price, int mass, String description,
			boolean isNew, boolean isSpicy, boolean forVegies, boolean iceCream) {
		super(name, price, mass, description, isNew, isSpicy, forVegies);
		this.iceCream = iceCream;
	}

	

}
