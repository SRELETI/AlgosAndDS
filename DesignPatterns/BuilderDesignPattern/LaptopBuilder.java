
public abstract class LaptopBuilder {

	private Laptop laptop;
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public Laptop getLaptop() { return laptop; }
	
	public final Laptop buildLaptop() {
		Laptop laptop2 = makeLaptop();
		setLaptop(laptop2);
		setScreen();
		setRam();
		setHardDisk();
		setBattery();
		setBrandName();
		return laptop;
	}
	public abstract Laptop makeLaptop();
	public abstract void setScreen();
	public abstract void setRam();
	public abstract void setHardDisk();
	public abstract void setBattery();
	public abstract void setBrandName();
	
}
