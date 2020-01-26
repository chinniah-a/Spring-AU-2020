package com.springAU.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Seller") 
public class Seller extends User{
	
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sellerId")
	private Collection<Product> products = new ArrayList<Product>(); // A seller can sell multiple products
	
	@Override
	public String toString() {
		return "Seller [products=" + products + "]";
	}

	public Seller( String username, String mobile_no, String email) {
		super( username, mobile_no, email);
		// TODO Auto-generated constructor stub
	}
	
	public Seller( String username, String mobile_no, String email,Address homeAddress) {
		super( username, mobile_no, email,homeAddress);
		// TODO Auto-generated constructor stub
	}

	public Collection<Product> getProductList() {
		return products;
	}

	public void setProductList(Collection<Product> products) {
		this.products = products;
	}

}
