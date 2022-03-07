package com.skilldistillery.jets.entities;

public class FlyinCars extends Jet implements Cargocarrier {

	public FlyinCars() {

	}

	// @Override
	public FlyinCars(String type, String model, double speed, int range, double price) {
		super(type, model, speed, range, price);

	}

	@Override
	public void loadCargo() {

		System.out.println("Standing by to load cargo on " + getModel());
		System.out.println("... Loading complete on " + getModel());
		System.out.println();
	}

	@Override
	public void fly() {
		System.out.println("Flying Car " + getModel() + " is wheels up.");
		double flyTime = getRange() / getSpeed();
		System.out.println("Based on our current speed of " + getSpeed() + " MPH,");
		System.out.println("Our maximum flying time is " + String.format("%.2f", flyTime) + " hours,");
		System.out.println("which will cover a range of " + getRange() + " miles.");

	}

}
