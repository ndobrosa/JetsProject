package com.skilldistillery.jets;

public abstract class Jet {
private String model;
private double speed;
private int range;
private long price;

public Jet (String model, double speed, int range, long price) {
	this.model = model;
	this.speed = speed;
	this.range = range;
	this.price = price;
}

public void fly () {
	System.out.println("model: " + model + "\ttop speed: " + speed + "\trange: " + range + "\tprice: " + price + "\ttime before crash: " + (range/speed));
}

public double getSpeedInMach() {
	
	return 0;
}
}
