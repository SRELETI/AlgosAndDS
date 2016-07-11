
public class Cheese extends DecoratorPizza  {

	private Pizza pizzaTemp;
	public Cheese(Pizza pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
		pizzaTemp = pizza;
		System.out.println("Adding cheese");
	}
	
	public String getDescription() {
		return pizzaTemp.getDescription()+", Cheese";
	}
	
	public double getCose() {
		return pizzaTemp.getCost()+ 0.40;
	}

}
