import java.util.Arrays;


public class StackStockSpan {
	private int[] stock;
	private int[] result;
	private StackArray stackk;
	public StackStockSpan(int[] arr)
	{
		stock=arr;
		result= new int[stock.length];
		stackk = new StackArray(stock.length);
	}
	public void calculate()
	{
		stackk.push(0);
		result[0]=1;
		for(int i=1;i<stock.length;i++)
		{
			while(!stackk.isEmpty() && stock[stackk.peek()]<stock[i])
				stackk.pop();
			result[i]=stackk.isEmpty() ? i+1 : i-stackk.peek();
			stackk.push(i);
		}
		System.out.println(Arrays.toString(result));
	}
}
