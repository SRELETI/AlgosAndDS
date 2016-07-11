
public class CountTrailing {

	public void count(int n)
	{
		int result = 0;
		for(int i=5;i<=n;i=i*5)
			result = result+ n/i;
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		CountTrailing c = new CountTrailing();
		c.count(100);
	}
}
