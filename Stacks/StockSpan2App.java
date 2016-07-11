
public class StockSpan2App {
	public static void main(String args[])
	{
		StockSpan2 ss = new StockSpan2(6);
		ss.add(10);
		ss.add(4);
		ss.add(5);
		ss.add(90);
		ss.add(120);
		ss.add(80);
		ss.display();
		ss.stock();
		
	}
}
