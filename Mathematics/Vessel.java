
public class Vessel {
	
	public int current;
	public int capacity;
	
	public Vessel(int cap)
	{
		current = 0;
		capacity=cap;
	}
	
	public void fill(int amount)
	{
		if(current+amount>=capacity)
			current = capacity;
		else
		{
			current = current+amount;
		}
	}
	
	
}
