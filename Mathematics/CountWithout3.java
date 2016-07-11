
public class CountWithout3 {

	public static void main(String args[])
	{
		CountWithout3 c = new CountWithout3();
		System.out.println(c.without3(578));
		System.out.println(c.without3(45));
	}
	
	public int without3(int n)
	{
		if(n<3)
			return n;
		if(3<=n && n<=9)
			return n-1;
		int po=1;
		while(n/po>9)
			po=po*10;
		int msd = n/po;
		if(msd==3)
		{
			return without3(msd*po-1);
		}
		else
			return without3(msd)*without3(po-1)	+without3(msd)+without3(n%po);
	}
	
}
