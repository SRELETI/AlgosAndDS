
public class MaxMinNo {

	public void maxMin(int a, int b)
	{
		int result = b+((a-b) & (a-b)>>Integer.SIZE-1);
		System.out.println(result);
		int result2 = a -((a-b) & (a-b)>>Integer.SIZE-1);
		System.out.println(result2);
	}
	
	public static void main(String args[])
	{
		MaxMinNo m = new MaxMinNo();
	//	m.maxMin(1, 1);
		m.set_bits(7);
		m.set_bits2(7);
		System.out.println(m.SuperFastSideSum_16(3));
	}
	
	public int SuperFastSideSum_16( int value )
	{
	  int result = value;
	  int S[] = {0,2,4,8,16};
	  int B[] = {0,0x55555555,0x33333333,0x0f0f0f0f,0x0000ffff};
	  result = ((result >> S[1]) & B[1]) + (result & B[1]);
	  result = ((result >> S[2]) & B[2]) + (result & B[2]);
	  result = ((result >> S[3]) & B[3]) + (result & B[3]);
	  result = ((result >> S[4]) & B[4]) + (result & B[4]);

	  return result;
	}
	
	
	public void set_bits2(int n)
	{
		int sum=0;
		for(int i=1;i<=n;i++)
			sum = sum+ count(i);
		System.out.println(sum);
	}
	
	private int count(int i)
	{
		if(i<=0)
			return 0;
		return (i%2==0 ? 0:1)+count(i/2); 
	}
	public void set_bits(int n)
	{
		int sum = 0;
		int s;
		for(int i=0;i<Integer.SIZE;i++)
		{
			s = 1<<i;
			for(int j=1;j<=n;j++)
			{
				if((j&s)>0)
					sum=sum+1;
			}
		}
		System.out.println(sum);
	}
}
