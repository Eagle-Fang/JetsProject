package com.skilldistillery.jets.entities;

public class MilitaryAircraft extends Jet implements Fighter {

	public MilitaryAircraft () {
		
	}
	
	public MilitaryAircraft(String type, String model, double speed, int range, double price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " is locked, loaded, and ready for action!");
		System.out.println(getModel() + " has engaged the target! Ready for next sortie.");
		System.out.println();
	}

	@Override
	public void fly() {
		System.out.println("Military Aircraft " + getModel() + " is wheels up.");
		double flyTime = getRange() / getSpeed();
		System.out.println("Based on our current speed of " + getSpeed() + " MPH,");
		System.out.println("Our maximum flying time is " + String.format("%.2f", flyTime) + " hours,");
		System.out.println("which will cover a range of " + getRange() + " miles.");

	}
}