package com.springAU.components;

import java.util.List;

public interface Component {
	String getName();
	int getArea();
	String stringifyComponents();
	int countComponents();
	List<Component> getComponents();
}
