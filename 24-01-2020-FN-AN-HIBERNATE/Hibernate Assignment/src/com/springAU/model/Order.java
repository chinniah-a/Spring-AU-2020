package com.springAU.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders") 
public class Order {
	
	@Id
	@GeneratedValue()
	private int orderId;
	
	@OneToOne
	private Payment payment;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	@ManyToOne
    private Buyer buyer;

	@ElementCollection
//	@CollectionTable(name="Order", joinColumns=@JoinColumn(name="order_id"))
	private Collection<Product> productList = new ArrayList();

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", payment=" + payment + ", buyer=" + buyer + ", productList="
				+ productList + "]";
	}
	
	
	
	

}
