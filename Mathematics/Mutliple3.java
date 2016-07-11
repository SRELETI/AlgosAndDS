
public class Mutliple3 {
	public static void main(String args[])
	{
		int n=0;
		System.out.println(is2(3));
	}
	public static boolean is(int n)
	{
		return n%3==0;
	}
	public static boolean is2(int n)
	{
		int odd_count=0;
		int even_count=0;
		if(n<0)
			n=-n;
		if(n==0)
			return true;
		if(n==1)
			return false;
		while(n!=0)
		{
			if((n&1) !=0)
				odd_count++;
			n=n>>1;
			if((n&1) !=0)	
				even_count++;
			n=n>>1;
		}
		if(odd_count-even_count==0)
			return true;
		else
			return false;
	}
}
