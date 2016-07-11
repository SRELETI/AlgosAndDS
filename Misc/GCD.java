
public class GCD {
	public static void main(String args[])
	{
		int result=Gcd(20,25);
		int result2=Gcd_non(20,25);
		int result3=raise_power(10,3);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}
	public static int Gcd(int p,int q)
	{
		if(q==0)
			return p;
		return Gcd(q,p%q);
	}
	public static int Gcd_non(int p,int q)
	{
		int temp;
		while(q!=0)
		{
			temp=q;
			q=p%q;
			p=temp;
		}
		return p;
	}
	public static int raise_power(int num,int pow)
	{
		if(pow==1)
			return num;
		return num*raise_power(num,pow-1);
	}
}
