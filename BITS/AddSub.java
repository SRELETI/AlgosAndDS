
public class AddSub {

	public int add(int x, int y)
	{
		int carry;
		while(y!=0)
		{
			carry = x & y;
			x = x ^ y;
			y = carry<<1;
		}
		return x;
	}
	
	public int sub(int x, int y)
	{
		return add(x,add(~y,1));
	}
	
	public int mul(int a, int b)
	{
		int x = a;
		for(int i=1;i<b;i++)
		{
			x = add(x,a);
		}
		return x;
	}
	
	public int division(int x, int y)
	{
		int mask = 0x1;
		int quo = 0;
		while(y<=x)
		{
			y = y<<1;
			mask = mask<<1;
		}
		
		while(mask>1)
		{
			y = y >>1;
			mask = mask >>1;
			if(x>=y)
			{
				x = x - y;
				quo = quo | mask;
			}
		}
		return quo;
	}
	
	public void next_sameBit(int x )
	{
		int smallest, ripples, ones;
		int result;
		smallest = x & -x;
		ripples = x + smallest;
		ones = x ^ ripples;
		ones = (ones>>2)/smallest;
		result = ones | ripples;
		System.out.println(result);
	}
	
	public void add_1(int x)
	{
		int m=1;
		while((x&m)!=0)
		{
			x = x ^ m;
			m = m<<1;
		}
		x = x^m;
		System.out.println(x);
	}
	
	public void mul_35(int x)
	{
		int result = (x<<1) + (x) + (x>>1);
		System.out.println(result);
	}
	
	public void mul_35_2(int x)
	{
		int result = ((x<<3)-x)/2;
		System.out.println(result);
	}
	public static void main(String args[])
	{
		AddSub a = new AddSub();
		System.out.println(a.add(2, 3));
		System.out.println(a.sub(3, 2));
		System.out.println(a.mul(6, 6));
		System.out.println(a.division(6, 3));
		a.next_sameBit(3);
		a.add_1(0);
		a.mul_35(5);
		a.mul_35_2(5);
	}
}
