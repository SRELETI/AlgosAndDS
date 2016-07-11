
public class SetBits_count {
	public static void main(String args[])
	{
		
	}
	public static void count(int n)
	{
		int count=0;
		for(int i=1;i<=n;i++)
		{
			count=count+bit_count(i);
		}
	}
	public static int bit_count(int k)
	{
		if(k<=0)
			return 0;
		return (k%2==0)?0:1 + bit_count(k/2);
	}
}
