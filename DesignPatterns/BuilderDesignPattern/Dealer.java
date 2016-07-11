
public class Dealer {

	private Laptop laptop = null;
	public Laptop makeLaptop(String brandOfLaptop) {
		if(brandOfLaptop.equals("Lenovo")) {
			LaptopBuilder lap = new LenovoBuilder();
			laptop = lap.buildLaptop();
		}
		else if(brandOfLaptop.equals("Sony")) {
			LaptopBuilder lap = new SonyBuilder();
			laptop = lap.buildLaptop();
		}
		else
			System.out.println("No such laptop is made here ");
		return laptop;
	}
}
