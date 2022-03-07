package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements Cargocarrier {

	
	public CargoPlane () {
		
	}
	
	public CargoPlane(String type, String model, double speed, int range, double price) {
		super(type, model, speed, range, price);
	}	
	

	public void loadCargo() {
		System.out.println("Standing by to load cargo on " + getModel());
		System.out.println("... Loading complete on " + getModel());
		System.out.println();
	}

	@Override
	public void fly () {
			System.out.println("Cargo Plane " + getModel() + " is wheels up.");
		double flyTime = getRange() / getSpeed();
		System.out.println("Based on our current speed of " + getSpeed() + " MPH,");
		System.out.println("Our maximum flying time is " + String.format("%.2f", flyTime) + " hours,");
		System.out.println("which will cover a range of " + getRange() + " miles.");
			
		}
	}

