
public class SonyBuilder extends LaptopBuilder {

	@Override
	public Laptop makeLaptop() {
		// TODO Auto-generated method stub
		return new Laptop();
	}

	@Override
	public void setScreen() {
		// TODO Auto-generated method stub
		System.out.println("Step 1: Screen size is set");
		getLaptop().setScreen("17.6");
	}

	@Override
	public void setRam() {
		// TODO Auto-generated method stub
		System.out.println("Step 2: Ram size is set");
		getLaptop().setRam("8GB");
	}

	@Override
	public void setHardDisk() {
		// TODO Auto-generated method stub
		System.out.println("Step 3: hard disk size is set");
		getLaptop().setHardDisk("1000GB");
	}

	@Override
	public void setBattery() {
		// TODO Auto-generated method stub
		System.out.println("Step 4: battery is set");
		getLaptop().setBattery("6 Cell");
	}

	@Override
	public void setBrandName() {
		// TODO Auto-generated method stub
		System.out.println("Step 5: Brand name is set");
		getLaptop().setBrandName("Sony");
	}

}
