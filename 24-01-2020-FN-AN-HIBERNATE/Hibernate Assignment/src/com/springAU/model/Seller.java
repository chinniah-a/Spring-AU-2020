package com.springAU.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seller") 
public class Seller extends User{
	
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="SELLER_ID")
	private Collection<Product> productList = new ArrayList();
	
	@Override
	public String toString() {
		return "Seller [productList=" + productList + "]";
	}

	public Seller( String username, String mobile_no, String email) {
		super( username, mobile_no, email);
		// TODO Auto-generated constructor stub
	}

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}

}
