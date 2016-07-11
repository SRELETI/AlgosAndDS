
public class printPrimes {

	public void prime(int num)
	{
		while(num%2==0)
		{
			System.out.print(2+" ");
			num= num/2;
		}
		
		int sqrt = (int)Math.sqrt(num);
		for(int i=3;i<=sqrt;i++)
		{
			while(num%i==0)
			{
				System.out.print(i+" ");
				num= num/i;
			}
		}
		
		if(num>2)
			System.out.println(num+" ");
	}
	
	public static void main(String args[])
	{
		printPrimes p = new printPrimes();
		p.prime(5);
		
	}
}
