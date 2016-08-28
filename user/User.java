package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import restaurant.Order;
import restaurant.Restaurant;
import consumable.Consumable;
import consumable.Pizza;
import consumable.Product;
import consumable.Pizza.doughType;
import consumable.Pizza.pizzaSize;

public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	//private Restaurant restaurant;
	private Map<String,Address> address;
	private Set<Pizza> favorites;
	private ArrayList orderList;
	private Map<Consumable,Integer> shoppingCart;
	
	public User(String username, String password, String firstName,
			String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = new HashMap<String,Address>();
		this.favorites = new HashSet<Pizza>();
		this.orderList = new ArrayList();
		this.shoppingCart = new HashMap<Consumable,Integer>();
	} 
	
	void addAddress(String title, String street, int streetNumber, int postcode,
			int floore, int appartmentNumber, String country, String city){
		Address newAddress = new Address(title, street, streetNumber, postcode,
				floore, appartmentNumber, country, city); 
		this.address.put(title, newAddress);
	}
	
	void removeAddress(String title){
		address.remove(title);
	}
	
	void addToCart(Consumable consumable, int count){
		if(shoppingCart.containsKey(consumable)){
			shoppingCart.put(consumable, shoppingCart.get(consumable)+count);
		}else{
			shoppingCart.put(consumable, count);
		}
	}

	void removeFromCart(Consumable consumable){
		shoppingCart.remove(consumable);	
	}
	
	void removeCountFromShoppingCart(Consumable consumable){

		if (shoppingCart.get(consumable) == 1) {
			removeFromCart(consumable);
		}else{
		shoppingCart.put(consumable, shoppingCart.get(consumable)-1);
		}
	}
	
	void AddCountToShoppingCart(){
		
	}

	void addToFavorites(Pizza pizza, String title){
		this.favorites.add(pizza);
	}
	
	void removeFromFavorites(Pizza pizza){
		this.favorites.remove(pizza);
	}
	
	void makeOrder(Restaurant restaurant, boolean delivery, Address address){
		Order newOrder = new Order(this,shoppingCart,delivery);
		orderList.add(newOrder);
		buy(restaurant, newOrder);
	}
	
	void buy(Restaurant restaurant, Order order){
		restaurant.sell(order);
	}
	
	void createPizza(String name, pizzaSize size, doughType dough, boolean addToFaves){
		Set pizzaPoducts = new HashSet<Product>();
		pizzaPoducts.add(new Product());
		Pizza userPiza = new Pizza(name, (HashSet<Product>) pizzaPoducts, size, dough);
		if (addToFaves) {
			addToFavorites(userPiza, name);
		}
	}
	
	void combinePizza(String name, pizzaSize size, doughType dough, boolean addToFaves){
		HashSet pizza1Poducts = new HashSet<Product>();
		HashSet pizza2Poducts = new HashSet<Product>();
		pizza1Poducts.add(new Product());
		pizza2Poducts.add(new Product());
		HashSet allProducts =  pizza1Poducts;
		allProducts.addAll(pizza2Poducts);
		Pizza userPiza = new Pizza(name, allProducts, size, dough);
		if (addToFaves) {
			addToFavorites(userPiza, name);
		}
	}
}
