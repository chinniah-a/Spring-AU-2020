package com.springAU.components;

import java.util.List;

public class Composite implements Component { // For Flats, Floors and Buildings
	
	String name;
	List<Component> components;
	int area = 0;
	
	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public Composite(String name, List<Component> components) {
		super();
		this.name = name;
		this.components = components;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public String toString() {
		return  "\n components:" + this.stringifyComponents()  +  "\n}";
	}
	
	public String listToString() {
		String s = "[";
		
		
		return s;
	}
	
	
	
	public String stringifyComponents() {
		String s = "\n";
		for(Component component : this.components) {
			s += component.toString() + ",\n";
		}
	
		
		return s;
	}
	
	
	public void addComponent(Component component) {
		this.components.add(component);
	}

	@Override
	public int getArea() {
		int totalArea = 0;
		for(Component component : this.components) {
			totalArea += component.getArea();
		}
		
		return totalArea;
	}

	@Override
	public int countComponents() {

		return this.components.size();
	}
	
	

}
