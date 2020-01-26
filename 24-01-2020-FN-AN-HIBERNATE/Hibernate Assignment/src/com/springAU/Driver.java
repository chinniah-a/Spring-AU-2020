package com.springAU;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springAU.model.Address;
import com.springAU.model.Buyer;
import com.springAU.model.Order;
import com.springAU.model.Payment;
import com.springAU.model.Product;
import com.springAU.model.Seller;



public class Driver {
	
	/**
	 * @param args
	 */
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); // Begin Session With the Database
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("**********************Online Marketplace Using Hibernate**********************");
		
		/*System.out.print("Please choose: \n1. Login\n2.Signup");
		
		boolean login = sc.nextInt()%2 == 1;
		
		
		if(login) {
			System.out.println("I am a:\n1.Seller\n2.Customer");
			
			int choice = sc.nextInt();
			
			
		}*/
		
		
		
		int choice = 0;
		
		while(choice!=3) { // Menu driven program to add products and do shopping
			
			
			System.out.println("Please Enter your details: ");
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Email: ");
			String email = sc.next();
			
			System.out.print("Contact No.: ");
			String contact = sc.next();
			
			System.out.print("Street name(no spaces): "); // Take details from the user
			String street = sc.next();
			
			System.out.print("Pincode: ");
			int pincode = sc.nextInt();
			
			Address address = new Address(pincode, street); // Take home Address
			
			System.out.println("*****************************************************");
			
			System.out.println("I am a:\n1.Seller\n2.Customer");
			
			choice = sc.nextInt();
				
		if(choice==1) {
			
			Seller seller = new Seller(name, contact, email,address);
			int sellerChoice =0;
			int sellerId = 0;
			
			System.out.print("Name Your first Product:");
			String productName = sc.next();
			System.out.print("What Is your product about:");
			String productDescription = sc.next();
			System.out.print("Product price:");
			int price = sc.nextInt();
			Product product = new Product(productName,price,productDescription);
			
			session.save(product);
	
			System.out.println(product.toString());
			
			seller.getProductList().add(product);
			
			sellerId = (Integer)session.save(seller);
	
			System.out.println("Your Id is: " + sellerId + " Please Remember it!");
			
			product = null;
			
			session.getTransaction().commit();
			
			session.beginTransaction();
		
			while(sellerChoice!=3) {
				System.out.println("1.Add Product \n2.View Product \n3.Exit");
				
				sellerChoice = sc.nextInt();
				switch(sellerChoice) {
			
					case 1:
						System.out.print("Name Your Product:");
						productName = sc.next();
						System.out.print("What Is your product about:");
						productDescription = sc.next();
						System.out.print("Product price:");
						price = sc.nextInt();
						product = new Product(productName,price,productDescription);
						
						session.save(product);
				
						System.out.println(product.toString());
						
						seller.getProductList().add(product);
						
						sellerId = (Integer)session.save(seller);
				
						System.out.println("Your Id is: " + sellerId + " Please Remember it!");
						
						session.getTransaction().commit();
						
						session.beginTransaction();
					
						break;
				
					case 2:
				
						Seller seller1 = session.get(Seller.class, sellerId);
						
						for(Product p:seller1.getProductList()) {
							
							System.out.println(p.toString());
							
							}
						
							break;
					
					case 3: 
						
							System.out.println("Thank You!");
					
							break;
					
					default:  System.out.println("Invalid option");
			
			}
		}
				
		}	
			
		if(choice==2) { // For buyer
			
			Buyer buyer = new Buyer(name, contact, email);
			
			int choice3=0;
			
			List<Product> cart = new ArrayList<Product>();
			
			while(choice3!=4){
				
				System.out.println("1. View Products\n2. Cart Products\n3. View Orders\n4.Exit");
				
				choice3 = sc.nextInt();
				
				switch(choice3) {
					case 1: 
							List<Product> products = (List<Product>)session.getNamedQuery(Product.GET_ALL_PRODUCTS).list();
							for(Product p:products) 
									System.out.println(p.toString());
									System.out.println("Enter Id to add to cart: ");
							int pid = sc.nextInt();
							List<Product> selectedProduct = session.createQuery("from Product where productid = " + pid,Product.class).list();
							cart.addAll(selectedProduct);
							//Order order = new Order();
							List<Product> selected = session.createQuery("from Product where productid = "+pid , Product.class).list();
							//order.getProductList().addAll(selected);
							//session.save(order);
							
							System.out.println("*****************************************************");
							System.out.println("Product" + selected.get(0).getProductNAme() + " Successfully Added to Cart.\n New Cart: ");
							
							
					
							int total = 0;
							for(Product product : cart) {
								System.out.println("Name: " + product.getProductNAme() + "Price: " + product.getPrice());
								total += product.getPrice();
								}
							System.out.println("Total: " + total);
							System.out.println("*****************************************************");
							session.save(buyer); 
							session.getTransaction().commit();
							session.beginTransaction();
					
							break;
				
					case 2: 
							
							System.out.println("*****************************************************");
							System.out.println("Cart:");
				
							total = 0;
				
							for(Product product : cart) {
								System.out.println("Name: " + product.getProductNAme() + "Price: " + product.getPrice());
								total += product.getPrice();
							}
							System.out.println("Total: " + total);
							System.out.println("*****************************************************\n\n");
							System.out.print("1. Confirm Order\n2.Go Back");
							int orderConfirmation = sc.nextInt();
							System.out.println("*****************************************************");
							int orderId;
							switch(orderConfirmation) {
							
								case 1:
									Order newOrder = new Order();
									Payment payment = new Payment();
									System.out.println("Payment Mode: ");
									payment.setPayment_amt(total);
									payment.setPayment_mode(sc.next());
									Date timeStamp = new Date();
									payment.setPayment_date(timeStamp);
									newOrder.setProductList(cart);
									newOrder.setPayment(payment);
									newOrder.setBuyer(buyer);
									session.save(payment);
									orderId = (Integer) session.save(newOrder);
									System.out.println("*****************************************************");
									System.out.println("Your Order Id is: " + orderId);
									System.out.println("Order: \n" + newOrder.toString());
									System.out.println("*****************************************************");
									break;
							}
				
							break;
					case 3:
						List<Order> orders = session.createQuery("from Order", Order.class).list();
						for(Order o: orders) {
							System.out.println(o.getProductList().toString());
						}
						break;
						
					case 4:System.out.println("Thank You!");
						System.out.println("*****************************************************");
						break;
						
					default:System.out.println("Invalid option");
				
			}
		}
			
		}
			
		
		else if (choice > 3) System.out.println("Invalid Choice");
		
		}
		
		
		sc.close();
	}

}
