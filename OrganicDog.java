
public class OrganicDog extends Organic implements Walkable {

	public OrganicDog(String name) {
		super(name);
	}

	@Override
	public void walk() {
		boredomLevel++;
		hungerLevel++;
		thirstLevel++;
	}

}
