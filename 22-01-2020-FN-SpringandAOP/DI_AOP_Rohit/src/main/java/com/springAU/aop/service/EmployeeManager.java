package com.springAU.aop.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springAU.aop.model.Employee;

@Component
public class EmployeeManager {
	
	private List<Employee> employeeList;
	
	public EmployeeManager(List<Employee> employeeList) {
		super();
		this.employeeList = employeeList;
	}
	
	
	public EmployeeManager() {
		// TODO Auto-generated constructor stub
	}

	public List<Employee> getAllEmployees(){
		
		
		System.out.println("getAllEmployees");
		
		return this.employeeList ;
	}
	

}
