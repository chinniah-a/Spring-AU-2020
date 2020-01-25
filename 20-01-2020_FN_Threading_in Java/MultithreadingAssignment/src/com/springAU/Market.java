package com.springAU;


import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Market {
	static String APPLE = "Apple",WATERMELON = "Watermelon", GRAPE = "Grape",ORANGE = "Orange";
	static HashMap<String, Integer> Basket = new HashMap<String,Integer>() {
		{
			put(APPLE,0);
			put(WATERMELON,0);
			put(GRAPE,0);
			put(ORANGE,0);
		}
	};
	static final int MAX_CAPACITY = 20, MAX_REQUEST = 10;
	// MAX _CAPACITY is the maximum number of total fruits in the market
	//MAX_REQUEST is the maximum number of fruits that a farmer can place or a Consumer can Consume
	static List<String> Fruits = new ArrayList<String>() { 
        { 
            add(APPLE); 
            add(WATERMELON); 
            add(GRAPE);
            add(ORANGE);
        } 
    }; 
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number of farmers:");
		int farmerCount = s.nextInt();
		System.out.println("Enter Number of Consumers:");
		int consumerCount = s.nextInt();
		
	
		System.out.println("Starting The Fruit Market.....");
			
			
		System.out.println("Starting All Farmer Threads");
		for(int i=0;i<farmerCount;i++) {
		Thread farmers = new Thread(new Farmer().farmer, "Farmer "+(i+1));
				 
			farmers.start();
			
		}
			
			System.out.println("Starting All Consumer Threads");
			for(int i=0;i<consumerCount;i++) {
				 
				 Thread consumers = new Thread(new Consumer().consumer, "Consumer "+(i+1));
				 
				 consumers.start();
			}
		}
		
			
				
	}


