package market;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Market {
	static final int APPLE = 0,ORANGE = 1,GRAPE = 2, WATERMELON = 3;
	static Map<Integer, Integer> marketContents = new HashMap<Integer, Integer>();
	static Map<Integer, String> marketMenu = new HashMap<Integer, String>();
	static int filled = 0,MAX_CAPACITY = 20,MAX_REQUEST = 1; // Change MAX_CAPACITY and MAX_REQUEST as it suits you
	static Executor executor=  Executors.newSingleThreadExecutor();;
	// MAX _CAPACITY is the maximum number of total fruits in the market
	//MAX_REQUEST is the maximum number of fruits that a farmer can place or a Consumer can Consume
	
	private static void initialize() {  // Start the market
		marketContents.put(APPLE, 0);
		marketContents.put(ORANGE, 0);
		marketContents.put(GRAPE, 0);
		marketContents.put(WATERMELON, 0);
		
		marketMenu.put(0, "Apple");
		marketMenu.put(1, "Orange");
		marketMenu.put(2, "Grape");
		marketMenu.put(3, "Watermelon");
		
	}
	
	static boolean isFull() {
		return filled == MAX_CAPACITY;
	}
	
	public static void main(String[] args) {
		initialize();
		
		Random random = new Random();
		int farmers;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Number of Farmers and Customers: ");
		farmers = s.nextInt();

		s.close();
		
		
		
		for(int i = 1; i <= farmers; i++) {
			
			new Thread(new Farmer(random.nextInt(4)).farmer, "Farmer_" + i).start(); // Start the Threads
			new Thread(new Customer(random.nextInt(4)).customer, "Customer_" + i).start();
			
		}
		
		
	}
}
