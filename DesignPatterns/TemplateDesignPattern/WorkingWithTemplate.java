
public class WorkingWithTemplate {

	public static void main(String args[]) {
		PizzaMake pizza = new HyderabadiPizza();
		pizza.makePizza();
		
		PizzaMake pizza2 = new IndianPizza();
		pizza2.makePizza();
	}
}
