package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		double timeFlying = range / speed;
		int intTimeFlying = (int) timeFlying;
		String minTimeFlying = "" + (int) ((timeFlying - intTimeFlying) * 60) + " minutes.";
		String message = "model: " + model + "top speed: " + speed + "range: " + range + "tprice: " + price
				+ "  time before crash: ";

		if ((int) timeFlying < 1) {
			System.out.println(message + minTimeFlying);
		} else if ((int) timeFlying == 1) {
			System.out.println(message + intTimeFlying + " hour " + minTimeFlying);
		} else {
			System.out.println(message + intTimeFlying + " hours " + minTimeFlying);
		}
	}

	public double getSpeedInMach() {

		return 0;
	}

	@Override
	public String toString() {
		return "Jet model=" + model + "    speed=" + speed + "    range=" + range + "    price=" + price;
	}
}
