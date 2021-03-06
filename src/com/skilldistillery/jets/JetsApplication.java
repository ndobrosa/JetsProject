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
			case 4:
				System.out.println(ja.getLongest());
				break;
			case 5:
				ja.loadCargoJets();
				break;
			case 6:
				ja.dogFight();
				break;
			case 7:
				ja.addJet();
				break;
			case 8:
				ja.flyIndividual();
				break;
			case 9:
				break;
			default:
				System.out.println("That option is not yet available");
			}
		} while (choice != 9);

		ja.launch();
	}

	public JetsApplication() {
	}

	private void flyIndividual() {
		Jet[] jets;
		jets = airfield.getJets();
		System.out.println("Choose the plane: ");
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				System.out.println((i + 1) + "." + jets[i].getModel());
			}
		}

		int choice = scanner.nextInt();
		jets[choice - 1].fly();
	}

	public void addJet() {
		scanner = new Scanner(System.in);
		System.out.println("Which plane would you like to add? \n");
		System.out.println("1. Fighter jet \n2. Cargo plane \n3. Regular jet");
		int choice = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the model: ");
		String model = scanner.nextLine();
		System.out.print("Enter the speed (MpH):");
		double speed = scanner.nextDouble();
		System.out.print("Enter the range: ");
		int range = scanner.nextInt();
		System.out.print("Enter the price: ");
		long price = scanner.nextLong();

		if (choice == 1) {
			for (int i = 0; i < jets.length; i++) {
				if (jets[i] == null) {
					jets[i] = new FighterJet(model, speed, range, price);
					System.out.println("Fighter jet parked in hangar " + i + ".");
					break;
				}
			}
		} else if (choice == 2) {
			for (int i = 0; i < jets.length; i++) {
				if (jets[i] == null) {
					jets[i] = new CargoPlane(model, speed, range, price);
					System.out.println("Cargo plane parked in hangar " + i + ".");
					break;
				}
			}
		} else if (choice == 3) {
			for (int i = 0; i < jets.length; i++) {
				if (jets[i] == null) {
					jets[i] = new JetImpl(model, speed, range, price);
					System.out.println("Jet parked in hangar " + i + ".");
					break;
				}
			}
		}
	}

	private void loadCargoJets() {
		CargoPlane x = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				if (jets[i] instanceof CargoCarrier) {
					if (jets[i] instanceof CargoPlane)
						x = (CargoPlane) jets[i];
					x.loadCargo();
				}
			}
		}

	}

	private void dogFight() {
		FighterJet x = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				if (jets[i] instanceof FighterJet) {
					x = (FighterJet) jets[i];
					x.fight();
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
		int choice;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null)
				System.out.println(jets[i]);
			choice = scanner.nextInt();
		}
	}

	private void launch() {
	}

	private int displayUserMenu() {
		System.out.println("What are your orders, Ma'am?");
		System.out.println(
				"1. List fleet \n2. Fly all jets \n3. View Fastest jet \n4. View jet with the longest range \n5. Load all Cargo Jets \n6. Dogfight! \n7. Add a jet to fleet! \n8. Fly an individual jet \n9. Quit");
		int choice = scanner.nextInt();
		return choice;

	}

}
