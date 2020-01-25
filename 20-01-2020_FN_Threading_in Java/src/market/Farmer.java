package market;

import java.util.Random;

public class Farmer {
	
	int fruit;
	int residual;
	Random random = new Random();
	int ins = 0;
	
	
	public Farmer(int fruit) {
		// TODO Auto-generated constructor stub
		this.fruit = fruit;
	}
	
	
	public static synchronized int placeFruits(int cropType, int quantity){
		int freeSpace = Market.MAX_CAPACITY - Market.filled;
		if(quantity <= freeSpace) {
			Market.filled += quantity;
			Market.marketContents.put(cropType, Market.marketContents.get(cropType) + quantity);
			return 0;
		}
		else {
			Market.filled = Market.MAX_CAPACITY;
			Market.marketContents.put(cropType, Market.marketContents.get(cropType) + freeSpace);
			
			return quantity - freeSpace;
		}
	}

	
	Runnable farmer = () -> {
		System.out.println(Thread.currentThread().getName() + " is alive and wants to place fruit: " + Market.marketMenu.get(this.fruit));
		
		while(true) {
			synchronized (Market.marketContents) {
				
				if(Market.isFull()) {
					try {
						Market.marketContents.wait();
					}
					catch (Exception ex) {
						System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
					}
				}
				else {
					
					
					int quantity = 0;
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					if(this.residual == 0)
					{
						this.fruit = this.random.nextInt(4);
						quantity = this.random.nextInt(Market.MAX_REQUEST)+1;
						System.out.println(Thread.currentThread().getName() + " needs to place " + quantity + " of fruit " + Market.marketMenu.get(this.fruit));
					}
					else {
						quantity = this.residual;
						System.out.println(Thread.currentThread().getName() + " still needs to place " + quantity + " of fruit " + Market.marketMenu.get(this.fruit) + " from previous order.");
					}
					
					
					 //= placeFruits(this.fruit, quantity);
					
					int freeSpace = Market.MAX_CAPACITY - Market.filled;
					if(quantity <= freeSpace) {
						Market.filled += quantity;
						Market.marketContents.put(this.fruit, Market.marketContents.get(this.fruit) + quantity);
						residual = 0;
					}
					else {
						Market.filled = Market.MAX_CAPACITY;
						Market.marketContents.put(this.fruit, Market.marketContents.get(this.fruit) + freeSpace);
						
						this.residual = quantity - freeSpace;
					}
					
					if(this.residual != 0) {
						
						System.out.println(Thread.currentThread().getName() + " still needs to place " + quantity + " of fruit " + Market.marketMenu.get(this.fruit));
						
					}
					else {
						System.out.println(Thread.currentThread().getName() + " placed " + quantity + " nos. of fruit " + Market.marketMenu.get(this.fruit));
					}
					
					Market.marketContents.notifyAll();
					
					System.out.println(Thread.currentThread().getName()+" notified.");	
					//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					this.ins += 1;
					
					if(this.ins > 2) {
						try {
							Market.marketContents.wait();
							Thread.sleep(3000);
							this.ins = 0;
							
						} catch (InterruptedException e) {
							
							
							System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
							
						}
					}
					try {
						Thread.sleep(this.random.nextInt(2000));
						
					} catch (InterruptedException e) {
						
						
						System.out.println(Thread.currentThread().getName() + " Has been Interrupted");
						
					}
				}
				
			}
		}

	};

}
