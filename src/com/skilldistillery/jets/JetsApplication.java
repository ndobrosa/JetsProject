package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField airfield = new AirField();
	private Scanner scanner = new Scanner(System.in);
	Jet[] jets = airfield.getJets();

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		JetsApplication ja = new JetsApplication();
		int choice = 0;

		ja.launch();

		do {
			choice = ja.displayUserMenu();
			switch (choice) {
			case 1:
				ja.printPlanes();
				break;
			case 2:
				ja.fly();
				break;
			case 3:
				System.out.println(ja.getFastest());
				break;
			case 4: System.out.println(ja.getLongest());
				break;
			case 5: ja.loadCargoJets();
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (choice != 8);

		ja.launch();
	}

	public JetsApplication() {
	}
	
	private void loadCargoJets() {
		CargoPlane x = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				if(jets[i] instanceof CargoCarrier) {
					x = (CargoPlane) jets[i];
					x.loadCargo();
				}
			}
		}
		
	}

	private Jet getFastest() {
		Jet fastestJet = null;
		double currentRecord = 0.0;

		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				if (currentRecord < jets[i].getSpeed()) {
					currentRecord = jets[i].getSpeed();
					fastestJet = jets[i];
				}
			}
		}
		return fastestJet;

	}
	
	private Jet getLongest() {
		Jet longestJet = null;
		double currentRecord = 0.0;
		
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				if (currentRecord < jets[i].getRange()) {
					currentRecord = jets[i].getRange();
					longestJet = jets[i];
				}
			}
		}
		return longestJet;
		
	}

	private void fly() {
		Jet[] jets;
		jets = airfield.getJets();
		for (Jet jet : jets) {
			if (jet != null) {
				jet.fly();
			}
		}
	}

	private void printPlanes() {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null)
				System.out.println(jets[i]);
		}
	}

	private void launch() {
		System.out.println("hello world");
	}

	private int displayUserMenu() {
		System.out.println("What are your orders, Ma'am?");
		System.out.println(
				"1. List fleet \n2. Fly all jets \n3. View Fastest jet \n4. View jet with the longest range \n5. Load all Cargo Jets \n6. Dogfight! \n7. Add a jet to fleet! \n8. Quit");
		int choice = scanner.nextInt();
		return choice;

	}

}
