package com.springAU.components;

import java.util.List;

public class Leaf implements Component {
	
	String name;
	int area;
	
	
	

	public Leaf(String name,int area) {
		super();
		this.name = name;
		this.area = area;
	}

	
	@Override
	public String toString() {
		return this.name + ": {\n\tname=" + this.stringifyComponents() +" \n\tarea: "+  this.getArea() + "\n}";
	}
	
	
	@Override
	public String getName() {

		return this.name;
	}

	
	public int getArea() {
		return this.area;
	}

	@Override
	public String stringifyComponents() {

		return this.name;
	}

	@Override
	public int countComponents() {

		
		return 1;
	}

	@Override
	public List<Component> getComponents() {

		return null;
	}
	
	
	

}
