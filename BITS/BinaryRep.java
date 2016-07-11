
public class BinaryRep {

	public void find(int x)
	{
		if(x<0)
			System.out.print(1);
		else
			System.out.print(0);
		int j=1<<30;
		while(j!=0)
		{
			if((x&j)!=0)
				System.out.print(1);
			else
				System.out.print(0);
			j=j/2;
		}
		
	}
	public void rec_print(int x)
	{
		if(x>1)
			rec_print(x/2);
		System.out.print(x%2);
	}
	public void shift(int x)
	{
		int even = x & (0xAAAAAAAA);
		
		int odd = x & (0x55555555);
		
		even = even>>1;
		odd = odd<<1;
		System.out.println(even|odd);
	}
	public static void main(String args[])
	{
		BinaryRep b = new BinaryRep();
	//	b.find(2147483647);
		b.shift(23);
	//	b.rec_print(4);
	//	System.out.println(Integer.MAX_VALUE);
	}
}
