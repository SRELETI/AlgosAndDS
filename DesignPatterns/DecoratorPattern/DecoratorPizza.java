
public abstract class DecoratorPizza implements Pizza{

	protected Pizza newPizza;
	public DecoratorPizza(Pizza pizza) {
		newPizza = pizza;
	}
	
	public String getDescription() {
		return newPizza.getDescription();
	}
	
	public double getCost() {
		return newPizza.getCost();
	}
}
