import java.util.Scanner;

public class App {

	private Scanner input;
	private Shelter myShelter;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Virtual Pet Game");
		App myApp = new App();
		myApp.gameLoop();
	}

	public void gameLoop() {
		myShelter = new Shelter();
		input = new Scanner(System.in);

		while (!myShelter.getDeadPets()) {
			//System.out.println(myShelter.showAllPets());
			showMainMenu();
			
			int selection = input.nextInt();
			input.nextLine();

			switch (selection) {
			case 0: 
				cleanQuit();				
			case 1:
				adoptPet();
				break;
			case 2:
				admitPet();
				break;
			case 3:
				showFoodMenu();
				selection = input.nextInt();
				input.nextLine();
				switch (selection) {
				case 1:
					myShelter.giveFoodToAllOrganics();
					break;
				case 2:
					myShelter.giveWaterToAllOrganics();
					break;
					}	
				break;
			case 4:
				showMaintenanceMenu();
				selection = input.nextInt();
				input.nextLine();
				switch (selection) {
				case 1:
					myShelter.repairAllRobotics();
				case 2:
					myShelter.chargeAllRobotics();
				}
			case 5:
				myShelter.playWithAllPets();
				System.out.println("Everyone had so much fun!");
				myShelter.printStatuses();
				break;
			case 6:
				myShelter.printStatuses();
			}
			myShelter.tickAllPts();
		}
		cleanQuit();
	}

	// proper exit point
	private void cleanQuit() {
		System.out.println("Thank you for playing!");
		input.close();
	}

	public void showMainMenu() {
		System.out.println("What would you like to do?");
		System.out.println("0. quit");
		System.out.println("1. to adopt a pet");
		System.out.println("2. add a new pet");
		System.out.println("3. food/water for pets");
		System.out.println("4. maintenance for pets");
		System.out.println("5. play with pets");
		System.out.println("6. display information about pets");
		System.out.println(">");
	}

	public void adoptPet() {
		System.out.println("Enter the name of the pet you wish to adopt:\n>");
		String petToAdopt = input.nextLine();
		try {
			myShelter.adopt(petToAdopt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void admitPet() {
		System.out.println("Enter the name of the pet you wish to admit:\n>");
		String petToAdmit = input.nextLine();
		boolean isRobotic;
		boolean isDog;
		System.out.println("Is the pet robotic? Y/N?\n>)");
		if (input.nextLine().toLowerCase().contains("y")) {
			isRobotic = true;
		} else
			isRobotic = false;

		System.out.println("Is the pet a dog? Y/N?\n>)");
		if (input.nextLine().toLowerCase().contains("y")) {
			isDog = true;
		} else
			isDog = false;

		myShelter.addPet(makePet(petToAdmit, isRobotic, isDog));

	}
	
	public void showFoodMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Give food to all organic pets");
		System.out.println("2. Give water to all organic pets");
		// System.out.println("3. Feed one pet");
		System.out.println("food/water>");
	}
	
	public void showMaintenanceMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Repair all pets");
		System.out.println("2. Charge all pets");
		// System.out.println("3. Repair one pet");
		System.out.println("maintenance>");
	}

	public VirtualPet makePet(String name, boolean isRobotic, boolean isDog) {
		if (isRobotic && isDog) {
			return new RoboticDog(name);
		} else if (isRobotic && !isDog) {
			return new RoboticCat(name);
		} else if (!isRobotic && isDog) {
			return new OrganicDog(name);
		} else if (!isRobotic && !isDog) {
			return new OrganicCat(name);
		}
		;
		return null;

	}

}
