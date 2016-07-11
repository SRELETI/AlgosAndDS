
public class Engine extends CarDecorator {

	private Car car;
	public Engine(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
		this.car = car;
		System.out.println("Adding car");
	}
	
	public String getMaker() {
		return car.getMaker()+", Deisel";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return car.cost()+500000;
	}
	

}
