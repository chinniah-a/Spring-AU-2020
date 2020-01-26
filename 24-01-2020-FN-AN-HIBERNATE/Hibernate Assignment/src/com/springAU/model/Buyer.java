package com.springAU.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="buyers") 
public class Buyer extends User{

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="BUYER_ID")
	private Collection<Order> orderList = new ArrayList<Order>();
	
	@Transient
	Collection<Product> cart = new ArrayList<Product>();

	public Collection<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}
	
	public Buyer(String username, String mobile_no, String email) {
		super(username, mobile_no, email);
		// TODO Auto-generated constructor stub
	}

}
