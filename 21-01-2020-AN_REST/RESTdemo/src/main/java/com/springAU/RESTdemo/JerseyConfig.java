package com.springAU.RESTdemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.springAU.RESTdemo.home.HomeController;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(HomeController.class);	
	}

}
