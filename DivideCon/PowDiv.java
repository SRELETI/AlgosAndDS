
public class PowDiv {

	public int pow(int x, int n)
	{
		if(n==0)
			return 1;
		if(n%2==1)
			return x*pow(x,n/2)*pow(x,n/2);
		else
			return pow(x,n/2)*pow(x,n/2);
	}
	
	public int pow2(int x, int n)
	{
		if(n==0)
			return 1;
		int temp = pow2(x,n/2);
		if(n%2==1)
			return x*temp*temp;
		else
			return temp*temp;
	}
	
	public double pow3(int x, int n)
	{
		if(n==0)
			return 1;
		double temp = pow3(x,n/2);
		if(n%2==0)
			return temp*temp;
		else
		{
			if(n>0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}
	
	public static void main(String args[])
	{
		PowDiv p = new PowDiv();
		System.out.println(p.pow(2, 3));
		System.out.println(p.pow2(2, 3));
		System.out.println(p.pow3(2, -3));
	}
}
