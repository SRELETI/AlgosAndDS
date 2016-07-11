
public class CarMaker {

	public static void main(String args[]) {
		Car newCar = new Color(new Engine(new Carbody()));
		System.out.println(newCar.getMaker());
		System.out.println(newCar.cost());
	}
}
