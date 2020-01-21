package com.springAU.RESTdemo.model;

public class User {
	
	int id;
	String name;
	
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		User user1 = (User)obj;
		return this.id == user1.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User(int id,String name){
		this.id = id;
		this.name = name;
		
	}
	

}
