package shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
//import java.util.Random;
import java.util.Scanner;

public class Main {
	
	HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
	HashMap<Integer,Product> catalog = new HashMap<Integer,Product>();
	HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
	List<Order> orderList = new ArrayList<Order>();
	
	int balance = 10000;
	
	public void addToCart(int i, int j) { //Adding Items to cart
		
		
		if(!this.catalog.containsKey(i)) {
			System.out.println("No such Item Available!");
			return;
		}
		if(j <= 0) {
			System.out.println("Please Enter A valid quantity");
		}
		
		if(this.catalog.get(i).quantity < j) {
			System.out.println("Cart Addition Exceeds Available Quantity \n");
			return;
		}
		if(this.cart.containsKey(i)) {
			this.cart.put(i, j + this.cart.get(i));
			return;
		}
		this.cart.put(i, j);
		
	}

	
	public void deleteFromCart(int itemId) { //Remove elements from Cart
		
		if(!this.cart.containsKey(itemId)) {
			
			System.out.println("No such Item In Cart!");
			return;
		}
		
		this.cart.remove(itemId);
	}
	
	int printCart(HashMap<Integer,Integer> cart) { // Show the contents of the cart or order 
		int total = 0;
		for(int i : cart.keySet()) {
			
			int subTotal = cart.get(i)* this.catalog.get(i).price;
			System.out.println("Item Id: " + i + "\tQuantity: " + cart.get(i) + "\tSub-Total: " + (subTotal));
			total += subTotal;
			
		}
		
		System.out.println("Total: " + total);
		System.out.println("==============================================");
		return total;
		
	}
	
	public int placeOrder(String username) { //Place order and check for sufficient balance

		
		if(!this.cart.isEmpty()) {
			System.out.println("Order Details: ");
			int amount = this.printCart(this.cart);
			if(amount > this.balance)
			{
				System.out.println("Insufficient Balance");
				return -1;
			}
			
			for(int i : cart.keySet()) {
			catalog.get(i).quantity -= cart.get(i);
			}
		
			this.orderList.add(new Order(orderList.size() + 1,username,cart));
			this.orders.put(this.orderList.size(), new Order(orderList.size() + 1,username,cart));
			this.balance -= amount;
			System.out.println("Order placed successfully!\nYour Order Id is " + this.orderList.size());
			this.cart.clear();
		
		}
		else {
			System.out.println("Your Cart is Empty");
		}
		
		return orderList.size();
	}
	
	public int cancelOrder(int orderId) {      //Order Cancellation
		
		if(this.orders.containsKey(orderId))
		{
			for (int i: orders.get(orderId).order.keySet()) {
				catalog.get(i).quantity += orders.get(orderId).order.get(i);
			}
			
			System.out.println("Deleting order: ");
			int amount  = printCart(this.orders.get(orderId).order);
			this.balance += amount;
			orders.remove(orderId);
			
		}
		else {
			System.out.println("No Such Order Exists");
		}
		
		return 0;
		
	}
	
	public void printOrders() {
		for(int i : orders.keySet()) {
			System.out.println("OrderID: " + i);
			this.printCart(orders.get(i).order);
		}
	}
	
	

	public void viewBalance() {
		System.out.println("Balance: " + this.balance);
	}
	
	
	
	
	//Driver
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		//Random random = new Random();
		Main m = new Main();		
		m.catalog.put(1,new Product(1, "Chocolate", 100, 50));
		m.catalog.put(2,new Product(2, "Laptop", 100, 50));
		m.catalog.put(3,new Product(3, "Desktop", 100, 50));
		m.catalog.put(4,new Product(4, "Bag", 100, 50));
		m.catalog.put(5,new Product(5, "Cabinet", 100, 50));
		m.catalog.put(6,new Product(6, "Book", 100, 50));
		m.catalog.put(7,new Product(7, "Furniture", 100, 50));
		m.catalog.put(8,new Product(8, "Mouse", 100, 50));
		m.catalog.put(9,new Product(9, "Keyboard", 100, 50));
		m.catalog.put(10,new Product(10, "Bro", 100, 50));
		
		m.printcatalog(m.catalog);
		
		System.out.print("Enter Username: ");
		String username = s.nextLine();
		System.out.println("Hello " + username);
		
		
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("Enter Your choice: \n1. Add item to cart.\n2. Remove from cart.\n3. View Cart\n4. Place Order\n5. Cancel Order.\n6. Print Catalog\n7. View Balance\n8. Exit");
			
			
			int choice ;
			try {
			choice = Integer.parseInt(s.next());
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter valid Input");
				continue;
				}
			
			
			int i,j;
			switch(choice) {
			case 1: 
					try {
					System.out.println("Enter Id and Quantity of the Product: ");
					i = s.nextInt();
					j = s.nextInt();
					m.addToCart(i, j);
					break;
					}
					catch(InputMismatchException e) {
						System.out.println("Please enter valid Input");
						break;}
					
					
			case 2:
				if(m.cart.isEmpty()) {
					System.out.println("==============================================");
					System.out.println("Cart is Empty");
					System.out.println("==============================================");
					break;
				}
				try {
					System.out.println("Enter Id of the Product:");
					i = s.nextInt();
					m.deleteFromCart(i);
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("Please enter valid Input");
					break;}
				
			case 3:
				if(m.cart.isEmpty()) {
					System.out.println("==============================================");
					System.out.println("Cart is Empty");
					System.out.println("==============================================");
					break;
				}
				System.out.println("==============================================");
				System.out.println("Your Cart:");
				m.printCart(m.cart);
				break;
				
			case 4:
				System.out.println("==============================================");
				m.placeOrder(username);
				System.out.println("==============================================");
				break;
				
				
			case 5:
				
				if(m.orders.isEmpty()) {
					System.out.println("==============================================");
					System.out.println("No orders to Delete");
					System.out.println("==============================================");
					break;
				}
				System.out.println("==============================================");
				m.printOrders();
				try {
				System.out.println("Enter OrderId To delete: ");
				m.cancelOrder(s.nextInt());
				m.printcatalog(m.catalog);
				break;
				}
				catch(InputMismatchException e) {
					System.out.println("Please enter valid Input");
					break;}
				
				
			case 6:
				m.printcatalog(m.catalog);
				break;
				
				
			case 7:
				System.out.println("==============================================");
				m.viewBalance();
				System.out.println("==============================================");
				break;
				
				
			case 8:
				exit = true;
				System.out.println("Thank You!");
				s.close();
				break;
				
				
			}}
			
			
		
		
				
		
		//s.close();
	}
	

	
	void printcatalog(HashMap<Integer,Product> catalog) {
		System.out.println("Catalog: ");
		for(int i : catalog.keySet()) {
			System.out.println(catalog.get(i).toString() + "\n");
		}
}
}