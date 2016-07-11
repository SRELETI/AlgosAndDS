
public class RussianMul {

	public static void main(String args[])
	{
		
		RussianMul r = new RussianMul();
		r.mul(18, 1);
		r.mul(4, 6);
	}
	
	public void mul(int a, int b)
	{
		int res = 0;
		while(b>0)
		{
			if((b & 1)==1)
				res = res + a;
			a= a<<1;
			b= b>>1;
		}
		System.out.println(res);
	}
}
