
public class FibonacciNumber {

	public boolean isFib(int num)
	{
		return issquare(5*num*num+4) || issquare(5*num*num-4);
	}
	
	private boolean issquare(int num)
	{
		int s = (int) Math.sqrt(num);
		return s*s==num;
	}
	public static void main(String[] args)
	{
		FibonacciNumber f = new FibonacciNumber();
		for(int i=0;i<10;i++)
			System.out.println("The "+i+" fib or not "+f.isFib(i));
	}
}
