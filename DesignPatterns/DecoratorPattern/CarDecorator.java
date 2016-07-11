
public abstract class CarDecorator implements Car {

	private Car carBody= null;
	
	public CarDecorator(Car car) {
		carBody = car;
	}
	
	public String getMaker() {
		return carBody.getMaker();
	}
	
	
	public double cost() {
		return carBody.cost();
	}
}
