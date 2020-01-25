package com.springAU;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Farmer {

	Runnable farmer = () -> {
		while(true) {
			
//			System.out.print(Thread.currentThread().getName()+" ");

			synchronized(Market.Basket) {
				 System.out.println("Capacity: "+ Market.MAX_CAPACITY);
				 System.out.println("Filled: " + getTotal(Market.Basket)); // Farmer method
				if(getTotal(Market.Basket) > Market.MAX_CAPACITY) {
					System.out.println("No Space Currently Available in Market!");
					try {
						Market.Basket.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Market.Basket);
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				}
				else {
					Random random = new Random(); 
			        // Generate random integers in range 1 to 15 
			        int quantity = random.nextInt(Market.MAX_REQUEST) + 1;
			        int fruit = random.nextInt(4);
			        String fruitName = Market.Fruits.get(fruit);
			        int available  = Market.Basket.get(fruitName);
			        
			        System.out.println(Thread.currentThread().getName()+" wants to add "+quantity+ " of " + fruitName+ "(s)");
			        
			        if(quantity+getTotal(Market.Basket) > Market.MAX_CAPACITY) {
			        	System.out.println(quantity + " exceeds remaining market capacity");
			        	try {
							Market.Basket.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        else {
			        	Market.Basket.put(fruitName ,available+quantity);
				        System.out.println(Thread.currentThread().getName()+" adds "+quantity+ " of " + fruitName + "(s)");
				        Market.Basket.notifyAll();
				        System.out.println("Market: ");
						System.out.println(Market.Basket);
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				        
				        try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }  
					
				}

			}
		}
		
	};
	
	public int getTotal(HashMap<String,Integer> fruits) {
		
		int total = 0;
		for (Map.Entry mapElement : fruits.entrySet()) 
            total+=(int)mapElement.getValue(); 
	
		return total;
	}

}
