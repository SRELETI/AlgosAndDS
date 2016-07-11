
public class Powerof2 {

	public void power(int x)
	{
		double s = (Math.log(x))/Math.log(2);
	//	System.out.println(s);
		int ceil = (int)Math.ceil(s);
		System.out.println((int)Math.pow(2, ceil));
	}
	public void power2(int x)
	{
		if((x & (x-1))==0)
		{
			System.out.println(x);
			
		}
		else
		{
			int count = 0;
			while(x>0)
			{
				x = x>>1;
				count++;
			}
			System.out.println(1<<count);
		}
	}
	
	public void power3(int c)
	{
		if( (c & c-1) ==0)
		{
			System.out.println(c);
		}
		else
		{
			int p=1;
			while(p<c)
			{
				p=p<<1;
			}
			System.out.println(p);
		}
	}
	
	public void power4(int c )
	{
		c = c-1;
		c = c| c>>1;
		c = c|c>>2;
		c = c|c>>4;
		c = c|c>>8;
		c = c|c>>16;
		System.out.println(c+1);
	}
	
	public static void main(String args[])
	{
		Powerof2 p = new Powerof2();
		p.power(5);
		p.power2(5);
		p.power3(5);
		p.power4(5);
	}
}
