package com.springAU;


import java.util.Random;

public class Consumer  {

	
	Runnable consumer = () -> {
		// TODO Auto-generated method stub
		while(true) {
			
//			System.out.print(Thread.currentThread().getName());
			synchronized (Market.Basket) {
				Random random = new Random(); 
		        //Generate random integers in range 1 to MAX_REQUEST
		        int quantity = random.nextInt(Market.MAX_REQUEST) + 1;
		        int fruit = random.nextInt(4);
		        String fruitName = Market.Fruits.get(fruit);

		        System.out.println(Thread.currentThread().getName() +" wants to buy "+quantity+" "+fruitName);
		        
				if(Market.Basket.get(fruitName)==0) {
					System.out.println(fruitName+" is not Available");
					System.out.println(Market.Basket);
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					try {
						
						Market.Basket.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
				
					System.out.println(fruitName+" is Available");
					int available = Market.Basket.get(fruitName);
					int val = 0;
					
					if(quantity > available)
						val = quantity-available;
					
					else 
						val = available-quantity;
					
					Market.Basket.put(fruitName, val);
					
					System.out.println(Thread.currentThread().getName()+" consumes "+quantity+" "+fruitName+" ");
					System.out.println(Market.Basket);
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Market.Basket.notifyAll();
				}
				

			}
		}
	 
	};
		
	}
	
	
		
		


