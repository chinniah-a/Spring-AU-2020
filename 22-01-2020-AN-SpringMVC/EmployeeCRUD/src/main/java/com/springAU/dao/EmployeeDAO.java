package com.springAU.dao;

import java.util.List;

import com.springAU.model.Employee;

public interface EmployeeDAO {
	public void saveOrUpdate(Employee employee);
	public void deletById(int Id);
	public Employee findById(int Id);
	public List<Employee> fetchAll(); 
}
