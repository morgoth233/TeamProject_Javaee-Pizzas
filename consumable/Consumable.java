package consumable;

import java.util.HashSet;
import java.util.Set;

public abstract class Consumable {

	protected String name;
	protected double price;
	protected int mass;
	protected String description;
	protected boolean isNew;
	protected boolean isSpicy;
	protected boolean forVegies;
	
	public Consumable(String name, double price, int mass, String description, boolean isNew, boolean isSpicy,
			boolean forVegies) {
		
		this.name = name;
		this.price = price;
		this.mass = mass;
		this.description = description;
		this.isNew = isNew;
		this.isSpicy = isSpicy;
		this.forVegies = forVegies;
	}
	
	public Consumable(String name){
		this.name = name;
	}
	
	public double getPrice(){
		return price;
	}
	
}
