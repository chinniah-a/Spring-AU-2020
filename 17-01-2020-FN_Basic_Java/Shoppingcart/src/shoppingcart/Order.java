package shoppingcart;

import java.util.HashMap;

// POJO for Order

public class Order {
	HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
	String username;
	int id;
	
	public Order(int id, String username,HashMap<Integer, Integer> order) {
		this.username = username;
		
		for (int i : order.keySet()) {
			this.order.put(i, order.get(i));
		}
		this.id = id;
	}
}
