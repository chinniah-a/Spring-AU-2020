package market;
import java.util.Random;;

public class Customer {
	
	int fruit;
	int residual = 0;
	int ins = 0;
	Random random = new Random();
	
	public Customer(int fruit) {
		// TODO Auto-generated constructor stub
		
		this.fruit = fruit;
	}
	
	
	public static int getFruits(int cropType, int quantity) {
		
		int available = Market.marketContents.get(cropType);
		
		if(available >= quantity) {
			Market.marketContents.put(cropType, available - quantity);
			Market.filled -= quantity;
			return 0;
		}
		else {
			Market.marketContents.put(cropType, 0);
			Market.filled -= (quantity - available);
			return quantity - available;
		}
		
	}

	Runnable customer = () -> {
		System.out.println(Thread.currentThread().getName() + " is alive and wants fruit: " + Market.marketMenu.get(this.fruit));
		
		while(true) {
			synchronized (Market.marketContents) {
				
				if(Market.marketContents.get(this.fruit) == 0) {
					try {
						Market.marketContents.wait();
					}
					catch (Exception e) {
						
						System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
					}
				}
				else {
					
					
					int quantity = 0;
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					if(this.residual == 0) // Check if any fruits needed from previous order
					{	
						this.fruit = this.random.nextInt(4); // Choose A random Fruit to consume
						quantity = this.random.nextInt(Market.MAX_REQUEST) + 1; // Thread will request a random amount of fruits
						System.out.println(Thread.currentThread().getName() + " needs " + quantity + " nos. of fruit " + Market.marketMenu.get(this.fruit));
					}
					else {
						
						quantity = this.residual; //take quantity as the last remaining fruits
						//System.out.println(Thread.currentThread().getName() + " still needs " + quantity + "nos. of fruit " + Market.marketMenu.get(this.fruit) + " from previous order.");
					}
					
					
					int available = Market.marketContents.get(this.fruit); 
					
					if(available >= quantity) { // Check if supply is more than demand
						Market.marketContents.put(this.fruit, available - quantity);
						Market.filled -= quantity;
						residual = 0;
					}
					else {
						Market.marketContents.put(this.fruit, 0); // Put unsupplied counts to the residual variable
						Market.filled -= (quantity - available);
						this.residual = quantity - available;
					}
					
					if(this.residual != 0) {
						
						System.out.println(Thread.currentThread().getName() + " still needs " + quantity + "nos. of fruit " + Market.marketMenu.get(this.fruit)); // If the order was incomplete
						
					}
					else {
						System.out.println(Thread.currentThread().getName() + " took " + quantity + " nos. of fruit " + Market.marketMenu.get(this.fruit));//If order is complete
					}
					
					Market.marketContents.notifyAll();
					
					System.out.println(Thread.currentThread().getName()+" notified."); // Notify
					//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					
					this.ins += 1; 
					
					if(this.ins > 2) {
						try {
							Market.marketContents.wait();
							Thread.sleep(200);
							this.ins = 0; // Sleep after 3 consecutive executions
							
						} 
						catch (InterruptedException e) {
							
							
							System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
							
						}
					try {
						
						Thread.sleep(this.random.nextInt(2000));
						
					} catch (InterruptedException e) {
						
						
						System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
						}
						
					}
				}
				
			}
		}

	};

}
