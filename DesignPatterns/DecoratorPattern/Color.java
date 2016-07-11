
public class Color extends CarDecorator {

	private Car car;
	public Color(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
		this.car = car;
		System.out.println("Adding color");
	}
	
	public String getMaker() {
		return car.getMaker()+", Vinyl";
	}
	
	public double getCost() {
		return car.cost()+ 200000;
	}

	
}
