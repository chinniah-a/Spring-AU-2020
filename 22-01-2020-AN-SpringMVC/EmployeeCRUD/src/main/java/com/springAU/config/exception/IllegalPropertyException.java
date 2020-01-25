package com.springAU.config.exception;

public class IllegalPropertyException extends Exception {
	
	String error;
	
	public IllegalPropertyException(String propertyName, String value) {
		// TODO Auto-generated constructor stub
		
		this.error = "The value of " + propertyName + " : " + value + " is Illegal.";
		System.out.println(this.error);
	}
	
	public String toString() {
		return this.error;
	}
}
