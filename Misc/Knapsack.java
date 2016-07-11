
public class Knapsack {
	private int weight;
	private int value;
	public Knapsack(int w,int v)
	{
		weight=w;
		value=v;
	}
	public int weight()
	{
		return weight;
	}
	public int value()
	{
		return value;
	}
	public void display()
	{
		System.out.println(weight +" "+value);
	}
}
