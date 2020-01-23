package com.springAU.aop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springAU.aop.model.Employee;
import com.springAU.aop.service.EmployeeManager;

@ComponentScan(basePackages = "com.* ")
public class App {
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //load beans from xml file
		
		EmployeeManager employeeManager = context.getBean(EmployeeManager.class);
		List<Employee> employees = employeeManager.getAllEmployees(); // Call method
		System.out.println("Data: "); //Print Data
		for(Employee e : employees) {
			System.out.println(e.toString());
		}
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
