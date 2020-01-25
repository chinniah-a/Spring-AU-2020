package com.springAU.model;
import java.util.regex.*; 

public class Employee {
	
	private int id = 0;
	private String firstName,lastName,contact;
	
	
	
	public Employee() {
		super();
	}



	public Employee(int id, String firstName, String lastName, String contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String[] validate() {
		
		Pattern name = Pattern.compile("[A-Za-z]*");
		Pattern number = Pattern.compile("[0-9]{10}");
		
		if(!name.matcher(this.firstName).matches()) {
			String[] result = {"First Name", this.firstName};
			return result;
		}
		else if(!name.matcher(this.lastName).matches()) {
			String[] result = {"Last Name", this.lastName};
			return result;
		}
		else if(!number.matcher(this.contact).matches()) {
			String[] result = {"Contact", this.contact};
			return result;
		}
		else {
			String[] result = {};
			return result;
		}
		
	}

	
	

}
