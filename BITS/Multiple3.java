
public class Multiple3 {

	public void check(int z)
	{
		if(z==0)
		{
			System.out.println("yes it is a multiple of 3");
			return;
		}
		if(z==1)
		{
			System.out.println("No it is not a multiple of 3");
			return;
		}
		if(z<0)
			z=-z;
		int odd_count = 0;
		int even_count = 0;
		int count=0;
		for(int i=0;i<Integer.SIZE;i++)
		{
			count++;
			if((z&(1<<i)) >0)
			{
				if(count%2==1)
					odd_count++;
				else
					even_count++;
			}
		}
		check(odd_count-even_count);
	}
	
	public void abs(int x)
	{
		int mask = x>>Integer.SIZE-1;
		x = mask+x;
		System.out.println(x^mask);
	}
	
	public static void main(String args[])
	{
		Multiple3 m = new Multiple3();
		m.check(7);
		System.out.println(m.parity(7)==true ? "odd parity": "even parity");
	}
	
	public boolean parity(int x)
	{
		boolean parity = false;
		while(x>0)
		{
			parity = !parity;
			x = x&(x-1);
		}
		return parity;
	}
}
