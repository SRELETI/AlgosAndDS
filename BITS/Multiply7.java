
public class Multiply7 {

	public void multiply(int x)
	{
		int result = sub((x<<3),x);
		System.out.println(result);
	}
	public static void main(String args[])
	{
		Multiply7 m = new Multiply7();
		m.multiply(4);
	}
	private int sub(int a, int b)
	{
		int result = add(a,add(~b,1));
		return result;
	}
	
	private int add(int a, int b)
	{
		int carry;
		while(b!=0)
		{
			carry = a&b;
			a = a^b;
			b = carry<<1;
		}
		
		return a;
	}
}
