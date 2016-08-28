package restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import user.User;
import consumable.Consumable;

public class Restaurant {
	
	enum productType{PIZZA,SALAD,DESSERT,DRINK,PASTA,STARTER,SAUSE}
	enum daysOfTheWeek{SUNDAY,MONDEY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}

	private String name;
	private String address;
	private double money;
	private Map<daysOfTheWeek,Date> workTime;
	private Map<productType,Set<Consumable>> menu;
	private Set<Consumable> deals;
	private Map<User,Map<Integer,Consumable>> orders;
	private List<Order> deliveryOrders;
	
	public Restaurant(String name, String address, double money,
			Date workTime, Map<productType, Set<Consumable>> menu) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.workTime = new HashMap<daysOfTheWeek,Date>();
		this.orders = new TreeMap<User,Map<Integer,Consumable>>();
		this.deals = new TreeSet<Consumable>();
		this.menu = new TreeMap<productType,Set<Consumable>>();
		this.deliveryOrders = new ArrayList();
	}
	
	public void sell(Order order){
		this.money += order.price;
		if(order.delivery == true){
			this.deliveryOrders.add(order);
		}
	}
	
	void deliver(){
		for(Order o: deliveryOrders){
			
		}
	}
	
	
}
