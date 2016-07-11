
public class Power {
	public static void main(String args[])
	{
		System.out.println(raise(10,3));
	}
	public static int raise(int a,int b)
	{
		if(b==0)
			return 1;
		if(a==0)
			return 0;
		if(b%2==0)
			return raise(a*a,b/2);
		else if(b%2==1)
			return a*raise(a*a,b/2);
		return 0;
	}
}	
