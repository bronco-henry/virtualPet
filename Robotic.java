
public abstract class Robotic extends VirtualPet {
	protected int batteryLevel;
	protected int durability;

	public Robotic(String name) {
		super(name);
		batteryLevel = 10;
		durability = 10;
	}

	// Methods
	@Override
	public void play() {
		batteryLevel--;
		durability--;
	}

	@Override
	public String status() {
		String statusMessage = "\n---" + name + "---"
				+ "\nType: " + this.getClass().getName() 
				+ "\nCharge level: " + batteryLevel
				+ "\nDurability: " + durability;
		return statusMessage;
	}
	
	@Override
	public void tick() {
	batteryLevel--;
	durability--;
	
	//check for death
	if(batteryLevel<=0 || durability<=0) {
		isAlive = false;
		System.out.println(name + " has died");
		System.out.println(status());
		}
	}

	public void giveCharge() {
		batteryLevel = 10;
	}

	public void repair() {
		durability = 10;
	}
}
