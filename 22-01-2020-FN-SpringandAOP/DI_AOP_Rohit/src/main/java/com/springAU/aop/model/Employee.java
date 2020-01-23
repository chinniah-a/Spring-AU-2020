package com.springAU.aop.model;

public class Employee {
	
	
	private int empId;
	private String Employee;
	private String position;

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", Employee=" + Employee + ", position=" + position + "] \n";
	}

	public Employee()
	{
		
	}
	
	public Employee(int empId, String employee, String position) {
		super();
		this.empId = empId;
		Employee = employee;
		this.position = position;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmployee() {
		return Employee;
	}
	public void setEmployee(String employee) {
		Employee = employee;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
