
public class TomatoSauce extends DecoratorPizza {

	private Pizza pizzaTemp;
	public TomatoSauce(Pizza pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
		System.out.println("Adding tomato sauce");
		pizzaTemp = pizza;
	}
	
	public String getDescription() {
		return pizzaTemp.getDescription()+", Tomato Sauce";
	}
	
	public double getCost() {
		return pizzaTemp.getCost()+0.35;
	}
}
