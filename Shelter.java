import java.util.ArrayList;

public class Shelter {
	private ArrayList<VirtualPet> pets;

	private boolean deadPets = false;

	public Shelter() {
		pets = new ArrayList<VirtualPet>();
		// starter pets
		pets.add(new RoboticCat("roboFuffy"));
		pets.add(new RoboticDog("roboPenny"));
		pets.add(new OrganicCat("Stan"));
		pets.add(new OrganicDog("Klaus"));
	}

	// output and formatting methods
	public void printStatuses() {
		for (int i = 0; i < pets.size(); i++) {
			System.out.println(pets.get(i).status());
		}
	}

	public String showAllPets() {
		String output = "";
		for (VirtualPet pet : pets) {
			output = output + pet.status() + "\n";
		}
		return output;
	}

	// shelter management methods
	public void addPet(VirtualPet pet) {
		pets.add(pet);

	}

	public void adopt(String petName) throws Exception {
		pets.remove(findPetByName(petName));
	}

	// food and water methods
	public void giveFoodTo(VirtualPet pet) {
		if (pet instanceof Organic) {
			((Organic) pet).giveFood();
			System.out.println(pet.getName() + " is not longer hungry");
		} else {
			System.out.println("Pet cannot eat");
		}
	}

	public void giveFoodToAllOrganics() {
		var organics = new ArrayList<String>();
		for (VirtualPet pet : pets) {
			if (pet instanceof Organic) {
				((Organic) pet).giveFood();
				organics.add(pet.getName());
			}
		}
		System.out.println(organics.toString() + " are no longer hungry");
	}

	public void giveWaterTo(VirtualPet pet) {
		if (pet instanceof Organic) {
			((Organic) pet).giveWater();
			System.out.println(pet.getName() + " is no longer thirsty");
		} else {
			System.out.println("Pet cannot drink");
		}
	}

	public void giveWaterToAllOrganics() {
		var organics = new ArrayList<String>();
		for (VirtualPet pet : pets) {
			if (pet instanceof Organic) {
				((Organic) pet).giveWater();
				organics.add(pet.getName());
			}
		}
		System.out.println(organics.toString() + " are no longer thirsty");
	}

	public void repairAllRobotics() {
		var robotics = new ArrayList<String>();
		for (VirtualPet pet : pets) {
			if (pet instanceof Robotic) {
				((Robotic) pet).repair();
				robotics.add(pet.getName());
			}
		}
		System.out.println(robotics.toString() + " are fully repaired");
	}

	public void chargeAllRobotics() {
		var robotics = new ArrayList<String>();
		for (VirtualPet pet : pets) {
			if (pet instanceof Robotic) {
				((Robotic) pet).giveCharge();
				robotics.add(pet.getName());
			}
		}
		System.out.println(robotics.toString() + " are fully charged");
	}

	public void playWithAllPets() {
		for (VirtualPet pet : pets) {
			pet.play();
		}
	}

	public void tickAllPts() {
		for (VirtualPet pet : pets) {
			pet.tick();
			if (!pet.isAlive()) {
				deadPets = true;
			}
		}
	}

	private VirtualPet findPetByName(String name) throws Exception {
		for (VirtualPet pet : pets) {
			if (pet.getName().equalsIgnoreCase(name)) {
				return pet;
			}
		}
		throw new Exception("Pet not found");
	}

	public void checkForDeadPets() {
		for (VirtualPet pet : pets) {
			if (!pet.isAlive()) {
				deadPets = true;
			}
		}
	}

	boolean getDeadPets() {
		return deadPets;
	}
}