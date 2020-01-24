package com.springAU;

import java.util.Arrays;
import java.util.List;

import com.springAU.components.Component;
import com.springAU.components.Composite;
import com.springAU.components.Leaf;

public class Driver {
	
	public static void main(String[] args) {
		
		Component studyRoom = new Leaf("Study Room",500);
		Component singleBedroom = new Leaf("Single Bedroom",350);  //Room Type
		Component masterBedroom = new Leaf("Master Bedroom",500);
		Component kitchen = new Leaf("Kitchen", 200);
		Component kitchenBig = new Leaf("Big Kitchen", 300);
		Component hall = new Leaf("Hall", 500);
		Component washroom = new Leaf("Toilet", 100);
		
		
		List<Component> oneBHKComponents = Arrays.asList(
				hall,
				singleBedroom,
				kitchen,
				washroom
				);
		
		Component oneBHKFlat = new Composite("One BHK Flat", oneBHKComponents); //Flats
		
		
		List<Component> twoBHKComponents = Arrays.asList(
														hall,
														singleBedroom,
														studyRoom,
														kitchen,
														masterBedroom,
														washroom
														);
		
		Component twoBHKFlat = new Composite("Two BHK Flat", twoBHKComponents);
		
		List<Component> threeBHKComponents = Arrays.asList(
				hall,
				singleBedroom,
				studyRoom,
				kitchenBig,
				masterBedroom,
				masterBedroom,
				washroom
				);

		Component threeBHKFlat = new Composite("Three BHK Flat", threeBHKComponents);
		
		List<Component> threeBHKBigComponents = Arrays.asList(
				hall,
				studyRoom,
				kitchenBig,
				masterBedroom,
				masterBedroom,
				masterBedroom,
				washroom
				);

		Component threeBHKBigFlat = new Composite("Three BHK Big Flat", threeBHKBigComponents);
		
		List<Component> groundFloorFlats = Arrays.asList(
				oneBHKFlat,
				oneBHKFlat,
				twoBHKFlat,
				twoBHKFlat
				);
		Component groundFloor = new Composite("Ground Floor", groundFloorFlats); //Floors
		
		
		List<Component> firstFloorFlats = Arrays.asList(
				oneBHKFlat,
				twoBHKFlat,
				threeBHKFlat,
				threeBHKFlat,
				threeBHKBigFlat
				);
		Component firstFloor = new Composite("First Floor", firstFloorFlats);
		
		
		
		List<Component> secondFloorFlats = Arrays.asList(
				twoBHKFlat,
				twoBHKFlat,
				threeBHKFlat,
				threeBHKFlat,
				threeBHKBigFlat
				);
		Component secondFloor = new Composite("Second Floor", secondFloorFlats);
		
		List<Component> buildingFloors = Arrays.asList(
				groundFloor,
				firstFloor,
				secondFloor
				);
		Component building = new Composite("Building", buildingFloors);
		
		
		System.out.println("-----------------------------------------------");
		System.out.println("|     Welcome to Spacious Housing Society     |");
		System.out.println("-----------------------------------------------");
		
		
		System.out.println("Number of Floors: " + building.countComponents());
		System.out.println("Building details: \n"  + "Total Area: " + building.getArea());
		
		for(Component component : buildingFloors) {
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			System.out.println("Floor: " + component.getName() + " Total Area: " + component.getArea());
			for (Component flat : component.getComponents()) {
				
				System.out.println("Flat: " + flat.getName() + " Total Area: " + flat.getArea() );
				for (Component room : flat.getComponents()) {
					
					System.out.println(room.getName() + " "  + "Area: " + room.getArea());
					
				}
				System.out.println("-----------------------------------------------");
				
				
			}
			
			
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			
		}
		
		
		
		
		
		
		
	}
	
	
	

}
