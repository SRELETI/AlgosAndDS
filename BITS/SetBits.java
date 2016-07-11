
public class SetBits {
	public static void main(String args[])
	{
		int n=8;
		System.out.println(set(n));
	}
	public static int set(int n)
	{
		int sum=0;
		for(int i=0;i<Integer.SIZE;i++)
		{
			int x=1<<i;
			for(int j=1;j<=n;j++)
			{
				if((j&x)!=0)
					sum++;
			}
		}
		return sum;
	}
}
