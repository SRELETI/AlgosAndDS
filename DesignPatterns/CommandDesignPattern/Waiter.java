import java.util.Stack;


public class Waiter {

	private Stack<FoodCommand> s;
	public Waiter() {
		s = new Stack<FoodCommand>();
	}
	
	public void add(FoodCommand f) {
		s.push(f);
		f.execute();
	}
}
