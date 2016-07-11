
public class CustomerCommand {
	
	public static void main(String args[]) {
		Cook c = new Cook();
		
		FoodCommand f = new BiryaniFoodCommand(c);
		FoodCommand f2 = new EggCurryFoodCommand(c);
		
		Waiter w = new Waiter();
		
		w.add(f);
		w.add(f2);
		
	}
}
