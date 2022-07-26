
public abstract class VirtualPet {
	// Fields
	protected String name;
	protected boolean isAlive;

	// Constructor

	public VirtualPet(String name) {
		this.name = name;
		isAlive = true;
	}

	// Methods
	public abstract void play();
	public abstract String status();
	public abstract void tick()
	;
	public String getName() {
		return name;
	}

	public boolean isAlive() {
		return isAlive;
	}

}
