package restaurant;

import java.util.Map;
import java.util.Map.Entry;

import consumable.Consumable;
import user.Address;
import user.User;

public class Order {
	
	User user;
	Map<Consumable, Integer> order;
	boolean delivery;
	double price;	
	Address address;
	
	public Order(User user, Map<Consumable, Integer> order, boolean delivery) {
		this.user = user;
		this.order = order;
		this.delivery = delivery;
		this.price = calcOrderPrice(order); 
	}
	
	double calcOrderPrice(Map<Consumable, Integer> orders){
		double total = 0;
		for (Entry<Consumable, Integer> o : orders.entrySet()) {
			total += o.getKey().getPrice()*o.getValue();
		}
		return total;
	}
	
}
