
public class Lucky {

	private class Wrapper
	{
		int count=2;
	}
	public boolean luck(int x, Wrapper counter)
	{
		if(x<counter.count)
			return true;
		if(x%counter.count==0)
			return false;
		x = x-(x/counter.count);
		counter.count++;
		return luck(x,counter);
	}
	
	public boolean luck(int x)
	{
		Wrapper w = new Wrapper();
		return luck(x,w);
	}
	public boolean isLucky(int x)
	{
		int counter = 2;
		while(counter<=x)
		{
			if(x%counter==0)
				return false;
			x=x-(x/counter);
			counter++;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		Lucky l = new Lucky();
		System.out.println(l.luck(7));
		System.out.println(l.isLucky(7));
	}
}
