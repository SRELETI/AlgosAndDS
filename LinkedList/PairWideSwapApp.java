
public class PairWideSwapApp {
	public static void main(String args[])
	{
		PairWiseSwap ps = new PairWiseSwap();
		ps.addFront(5);
		ps.addFront(4);
		ps.addFront(3);
		ps.addFront(2);
		ps.addFront(1);
		//ps.addFront(0);
		ps.display();
		//ps.swap();
		ps.swap_rec(ps.head);
		ps.display();
	}
}
