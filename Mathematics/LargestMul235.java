
public class LargestMul235
{
	public void bc(int n, int k)
	{
		int result = 1;
		int div = 1;
		if(k>n-k)
			k = n-k;
		for(int i=0;i<k;i++)
		{
			result = result * (n-i);
			result = result / (i+1); 
		}
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		LargestMul235 l = new LargestMul235();
		l.bc(8, 2);
	}
}