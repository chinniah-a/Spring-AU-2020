package com.springAU.difromproperties.model;
public class Point {
	
	private int X,Y;
	
	public Point(int X,int Y) {
		
		this.X = X;
		this.Y = Y;
	}


	
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public void draw() {
		
		System.out.println(this.toString());
		
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "Point [X=" + X + ", Y=" + Y + "]\n";
	}
	
	
}
