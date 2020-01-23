package com.springAU.difromproperties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.springAU.difromproperties.model.Point;

@Configuration
@ComponentScan("com.*")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Autowired
	Environment environment;  //System variable to get data from application.properties
	
	String X = "point.X";
	String Y = "point.Y";
	@Bean
	public Point getPoint() {
		return new Point(Integer.parseInt(environment.getProperty(X)), Integer.parseInt(environment.getProperty(Y)));  //get new instance
	}
	
}
