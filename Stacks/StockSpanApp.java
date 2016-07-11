
public class StockSpanApp {
	public static void main(String args[])
	{
		int[] arr =  {100, 80, 60, 70, 60, 75, 85};
		StackStockSpan ssp = new StackStockSpan(arr);
		ssp.calculate();
	}
}
