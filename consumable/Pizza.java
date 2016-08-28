package consumable;

import java.util.HashSet;
import java.util.Set;

public class Pizza extends Consumable {

	static final double EMPTY_PIZZA_PRICE = 7.50;
	
	public enum pizzaSize {
		AVARAGE, BIG, VERYBIG
	}

	public enum doughType {
		ITALIAN, CRUNCHY, TRADITIONAL
	}

	private pizzaSize size;
	private doughType dough;
	private Set<Product> pizzaProducts; 
	

	public Pizza(String name, HashSet<Product> products, pizzaSize size, doughType dough) {
		super(name);
		pizzaProducts = new HashSet<Product>();
		super.price = EMPTY_PIZZA_PRICE;
		this.size = size;
		switch (size) {
		case BIG:
			super.price += 2;
			break;
		case VERYBIG:
			super.price += 4;
			break;	
		}
		super.price += calcPizzaPrice(products);  
		this.dough = dough;

	}
	
	double calcPizzaPrice(HashSet<Product> products){
		double productsPrice = 0;
		for (Product p: products) {
			productsPrice += p.getProductPrice();
		}
		return productsPrice;
	}

}
