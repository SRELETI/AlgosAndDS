
public class AddTwo {

	public int add(int a, int b)
	{
		while(b!=0)
		{
			int carry = a & b ;
			a = a ^ b;
			b = carry << 1;
	
		}
		return a;
	}
	
	public int add_rec(int a, int b)
	{
		if(b==0)
			return a;
		return add_rec(a^b, (a&b)<<1);
	}
	
	public static void main(String args[])
	{
		AddTwo a = new AddTwo();
		System.out.println(a.add(1, 1));
		System.out.println(a.add_rec(1,1));
	}
}
