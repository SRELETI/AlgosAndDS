
public class PizzaMaker {

	public static void main(String args[]) {
		Pizza newPizza = new Cheese(new TomatoSauce(new PlainPizza()));
		System.out.println(newPizza.getDescription());
		System.out.println(newPizza.getCost());
	}
}
