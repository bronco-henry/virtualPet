
public abstract class Organic extends VirtualPet {
	// Fields
	protected int hungerLevel;
	protected int thirstLevel;
	protected int boredomLevel;

	// Constructor
	public Organic(String name) {
		super(name);
		hungerLevel = 0;
		thirstLevel = 0;
		boredomLevel = 0;
	}

	// Methods
	@Override
	public void play() {
		hungerLevel++;
		thirstLevel++;
		boredomLevel = 0;
	}

	@Override
	public String status() {
		String statusMessage = "\n---" + name + "---" 
				+ "\nType: " + this.getClass().getName() 
				+ "\nHunger: " + hungerLevel
				+ "\nThirst: " + thirstLevel
				+ "\nBoredom: " + boredomLevel;
		return statusMessage;
	}		
		@Override
		public void tick() {
		hungerLevel++;
		thirstLevel++;
		boredomLevel++;
		
		//check for death
	if(hungerLevel>=20 || thirstLevel>10) {
		isAlive = false;
		System.out.println(name + " has died:");
		System.out.println(status());
		}
		}
		
	public void giveFood() {
		hungerLevel = -1;
	}

	public void giveWater() {
		thirstLevel = -1;
	}

}
