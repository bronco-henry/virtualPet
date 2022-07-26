
public class RoboticDog extends Robotic implements Walkable{


	public RoboticDog(String name) {
		super(name);
	}

	@Override
	public void walk() {
		batteryLevel--;
		durability--;
	}
}
