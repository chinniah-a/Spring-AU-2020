package com.springAU.mapinjection.model;

import java.util.Map;

import com.springAU.aop.model.Employee;


public class MapInjectionExample {
	Map<Integer,Employee> map;
	
	
	
	public MapInjectionExample() {
		super();
	}



	public MapInjectionExample(Map<Integer, Employee> map) {
		super();
		this.map = map;
	}


	
	
	public Map<Integer, Employee> getMap() {
		return map;
	}



	public void setMap(Map<Integer, Employee> map) {
		this.map = map;
	}



	@Override
	public String toString() {
		return "MapInjectionExample [map: \n" + map.toString() + "\n]";
	}



	
	
}
