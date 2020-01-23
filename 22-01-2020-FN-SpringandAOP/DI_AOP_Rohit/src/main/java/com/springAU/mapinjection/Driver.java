package com.springAU.mapinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springAU.mapinjection.model.MapInjectionExample;


public class Driver {
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		MapInjectionExample example =(MapInjectionExample)applicationContext.getBean("mapexample"); // Inject The map
		System.out.println("Injected map is: ");
		System.out.println(example.toString());
		
		((AnnotationConfigApplicationContext) applicationContext).close();
		
		
	
	}

}
