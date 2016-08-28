package consumable;

import java.util.HashSet;

public class CombinedPizza extends Pizza{

	public CombinedPizza(String name, HashSet<Product> products,
			pizzaSize size, doughType dough) {
		super(name, products, size, dough);
		
	}

}
