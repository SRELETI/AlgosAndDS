
public class SetBit {

	public void power_4(int x)
	{
		while(x!=1)
		{
			if(x%4!=0)
			{
				System.out.println("not power of 4");
				return;
			}
			x = x/4;
		}
		System.out.println("Power of 4");
	}
	
	public void power_42(int x)
	{
		if((x & (x-1))==0)
		{
			int count =0;
			while(x>1)
			{
				count++;
				x=x>>1;
			}
			if(count%2==0)
			{
				System.out.println("power of 4 ");
				return;
			}
			System.out.println("Not power of 4");
			return;
		}
		System.out.println("not power of 4");
	}
	
	public void abs(int n)
	{
		int mask = n>>Integer.SIZE-1;
		
		int result = (mask+n)^mask;
		System.out.println(result);
	}
	public static void main(String args[])
	{
		SetBit s = new SetBit();
		s.power_4(64);
		s.power_42(64);
		s.abs(-2);
	}
}
