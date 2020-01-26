package com.springAU;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springAU.model.Buyer;
import com.springAU.model.Order;
import com.springAU.model.Payment;
import com.springAU.model.Product;
import com.springAU.model.Seller;



public class Driver {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("**********************Welcome to Online Marketplace**********************");
		
		/*System.out.print("Please choose: \n1. Login\n2.Signup");
		
		boolean login = sc.nextInt()%2 == 1;
		
		
		if(login) {
			System.out.println("I am a:\n1.Seller\n2.Customer");
			
			int choice = sc.nextInt();
			
			
		}*/
		
		
		
		int choice = 0;
		while(choice!=3) {
			
			System.out.println("Name:");
			String name = sc.next();
			
			System.out.println("Email:");
			String email = sc.next();
			
			System.out.println("Mobile:");
			String number = sc.next();
			
			
			System.out.println("*****************************************************");
			
			System.out.println("I am a:\n1.Seller\n2.Customer");
			
			choice = sc.nextInt();
				
		if(choice==1) {
			
			Seller seller = new Seller(name, number, email);
			int choice1 =0;
			int sellerId = 0;
			while(choice1!=3) {
				System.out.println("1.Add Product \n2.View Product \n3.Exit");
				
				choice1 = sc.nextInt();
				switch(choice1) {
			
					case 1:
						System.out.println("Product name:");
						String pName = sc.next();
						System.out.println("Product description:");
						String pDescription = sc.next();
						System.out.println("Product price:");
						int price = sc.nextInt();
//				session.save
//				for(Product p:seller.getProductList()) {
//					System.out.println(p.getProductNAme());
//					System.out.println(p.getDescription());
//					System.out.println(p.getPrice());
//				}
				
						Product product = new Product(pName,price,pDescription);
						
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
					
					case 3: System.out.println("Exit Successfully!");
					
							break;
					
					default:  System.out.println("Invalid option");
			
			}
		}
				
		}	
			
		if(choice==2) {
			
			Buyer buyer = new Buyer(name, number, email);
			
			int choice3=0;
			
			List<Product> cart = new ArrayList<Product>();
			
			while(choice3!=4){
				
				System.out.println("1. View Products\n2. Cart Products\n3. View Orders\n 3.Exit");
				
				choice3 = sc.nextInt();
				
				switch(choice3) {
					case 1: 
							List<Product> products = session.createQuery("from Product", Product.class).list();
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
							System.out.print("1. Confirm Order\n2. Cancel");
							int orderConfirmation = sc.nextInt();
							int orderId;
							switch(orderConfirmation) {
							
								case 1:
									Order order = new Order();
									Payment payment = new Payment();
									System.out.println("Please enter Mode of Payment: ");
									payment.setPayment_amt(total);
									payment.setPayment_mode(sc.next());
									DateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
									Date timeStamp = new Date();
									payment.setPayment_date(timeStamp);
									order.setProductList(cart);
									order.setPayment(payment);
									order.setBuyer(buyer);
									session.save(payment);
									orderId = (Integer) session.save(order);
									System.out.println("*****************************************************");
									System.out.println("Order: \n" + order.toString());
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
						
					case 4:System.out.println("Exit Successfully!");
						System.out.println("*****************************************************");
						break;
					default:System.out.println("Invalid option");
				
			}
		}
			
		}
			
		
		else System.out.println("Enter Correct option");
		
		}
	}

}
