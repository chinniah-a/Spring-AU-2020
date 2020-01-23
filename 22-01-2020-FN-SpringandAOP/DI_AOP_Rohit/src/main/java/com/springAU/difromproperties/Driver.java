package com.springAU.difromproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAU.difromproperties.config.AppConfig;
import com.springAU.difromproperties.model.Point;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Create Context from annotated Class
		
		Point p = applicationContext.getBean(Point.class);
		
		System.out.println(p.toString());  // application.properties contains X = 10 and Y = 20
		
		((AnnotationConfigApplicationContext) applicationContext).close();
		
	}
}
