package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FlyinCars;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.MilitaryAircraft;

public class JetApplication {

	private AirField airfield;
	private Scanner scanner;

	public JetApplication() {
		airfield = new AirField();
	}

	public static void main(String[] args) {
		JetApplication ja = new JetApplication();
		ja.airfield = new AirField();
		ja.scanner = new Scanner(System.in);

		// ja.readFromFile();
		ja.readFromFile();
		ja.launch(ja.scanner, ja.airfield.getJets());
	}

	public void launch(Scanner kb, List<Jet> jets) {
		airfield = new AirField();
		displayUserMenu(kb, jets);
	}

	private void displayUserMenu(Scanner kb, List<Jet> jets) {

		boolean keepgoing = true;

		while (keepgoing) {

			System.out.println();
			System.out.println("========= MENU ================");
			System.out.println("|                             |");
			System.out.println("|   1. List Fleet             |");
			System.out.println("|   2. Fly all Jets           |");
			System.out.println("|   3. View Fastest Jet       |");
			System.out.println("|   4. View Longest Range Jet |");
			System.out.println("|   5. Load all Cargo Jets    |");
			System.out.println("|   6. Dogfight!              |");
			System.out.println("|   7. Add a jet to Fleet     |");
			System.out.println("|   8. Remove jet from Fleet  |");
			System.out.println("|   9. Quit                   |");
			System.out.println("|                             |");
			System.out.println("===============================");
			System.out.println();
			System.out.println("Please choose 1 - 9: ");

			int choice = kb.nextInt();

			switch (choice) {

			case 1:
				displayAirField(jets);
				break;

			case 2:
				flyAllJets(jets);
				break;

			case 3:
				findFastest(jets);
				break;

			case 4:
				findLongestRange(jets);
				break;

			case 5:
				loadCargoJets(jets);
				break;

			case 6:
				conductDogFight(jets);
				break;

			case 7:
				addNewJet(jets, kb);
				break;

			case 8:
				removeJet(jets, kb);
				break;

			case 9:
				System.out.println("You have chosen to quit. Have a nice day.");
				keepgoing = false;
				break;

			default:
				System.out.println("That is not a valid choice. Please try again.");
			}
		}

	}

	private List<Jet> readFromFile() {
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;

			while ((line = bufIn.readLine()) != null) {
				String[] planeInfo = line.split(",");
				String jetClass = planeInfo[0];
				String model = planeInfo[1];
				double speed = Double.parseDouble(planeInfo[2]);
				int range = Integer.parseInt(planeInfo[3]);
				double price = Double.parseDouble(planeInfo[4]);

				if (jetClass.equals("Military Aircraft")) {
					Jet ma = new MilitaryAircraft(jetClass, model, speed, range, price);
					jets.add(ma);
				}

				if (jetClass.equals("Cargo Plane")) {
					Jet cp = new CargoPlane(jetClass, model, speed, range, price);
					jets.add(cp);
				}

				if (jetClass.equals("Flying Car")) {
					Jet fc = new FlyinCars(jetClass, model, speed, range, price);
					jets.add(fc);
				}

				airfield.setJets(jets);
			}

		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;

	}

	private void displayAirField(List<Jet> jets) {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	private void flyAllJets(List<Jet> jets) {
		for (Jet jet : jets) {
			jet.fly();
			System.out.println();
		}
	}

	private void findLongestRange(List<Jet> jets) {
		Jet highRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > highRange.getRange()) {
				highRange = jet;
			}
		}
		System.out.println("The longest range aircraft is: \t" + highRange);
	}

	private void findFastest(List<Jet> jets) {
		Jet fast = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > fast.getSpeed()) {
				fast = jet;
			}
		}
		System.out.println("The fastest aircraft is: " + fast);
	}

	private void loadCargoJets(List<Jet> jets) {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			} else if (jet instanceof FlyinCars) {
				((FlyinCars) jet).loadCargo();
			}
		}
	}

	private void conductDogFight(List<Jet> jets) {
		for (Jet jet : jets) {
			if (jet instanceof MilitaryAircraft) {
				((MilitaryAircraft) jet).fight();
			}
		}
	}

	private List<Jet> addNewJet(List<Jet> jets, Scanner kb) {
		int addChoice;
		String model = "";
		double speed = 0.0;
		int range = 0;
		double price = 0.0;

		System.out.println();
		System.out.println("========= MENU ================");
		System.out.println("| Enter type of jet to add    |");
		System.out.println("|   1. Flying Car             |");
		System.out.println("|   2. Military Aircraft      |");
		System.out.println("|   3. Cargo Plane            |");
		System.out.println("|   4. Return to Main Menu    |");
		System.out.println("|                             |");
		System.out.println("===============================");
		scanner = new Scanner(System.in);
		addChoice = scanner.nextInt();

		Jet jet = null;
		switch (addChoice) {

		case 1:
			jet = new FlyinCars("Flying Car", model, speed, range, price);
			break;
		case 2:
			jet = new MilitaryAircraft("Military Aircraft", model, speed, range, price);
			break;
		case 3:
			jet = new CargoPlane("Cargo Plane", model, speed, range, price);
			break;
		case 4:
			System.out.println("Returning to main menu");
			displayUserMenu(kb, jets);
		default:
			System.out.println("That is not a valid choice.");
		}

		System.out.println("Enter jet model/name: ");
		kb.nextLine();
		model = kb.nextLine();
		System.out.println("Enter speed: ");
		speed = kb.nextDouble();
		System.out.println("Enter range: ");
		range = kb.nextInt();
		System.out.println("Enter price: ");
		price = kb.nextLong();
		System.out.println("The new jet has been added successfully.");

		jets.add(jet);

		return jets;

	}

	private List<Jet> removeJet(List<Jet> jets, Scanner kb) {
		System.out.println("This is the current list of jets at our airfield. \n");
		int counter = 1; 
		for (Jet jet : jets) {
			System.out.println(counter + ":" + jet.getType() + ":" + jet.getModel());
			counter ++;
		}
		//displayAirField(jets);
		System.out.println("Which jet would you like to remove? Enter # from the list: ");
		int toRemove = kb.nextInt();
		
		toRemove--;
		jets.remove(toRemove);
		System.out.println("The jet has been successfully removed.");
		return jets;
	}

}
