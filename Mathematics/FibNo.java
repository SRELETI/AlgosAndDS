
public class FibNo {

	public int fib(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fib(n-1)+fib(n-2);
	}
	
	public static void main(String args[])
	{
		FibNo f = new FibNo();
	//	System.out.println(f.fib(4));
	//	System.out.println(f.f(9));
	//	System.out.println(f.f2(9));
		
		System.out.println(f.f3(10));
		System.out.println(f.f4(10));
	}
	
	public int f(int n)
	{
		int fib[] = new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<=n;i++)
		{
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n];
 	}
	
	public int f2(int n)
	{
		int a=0;
		int b=1;
		int c ;
		if(n==0)
			return a;
		for(int i=2;i<=n;i++)
		{
			c= a+b;
			a=b;
			b=c;
		}
		return b;
	}
	
	public int f3(int n)
	{
		if(n==0)
			return 0;
		int[][] fib = {{1,1},{1,0}};
		power_new(fib,n-1);
		return fib[0][0];
	}
	
	private void power_new(int[][] feb, int n)
	{
		if(n==0||n==1)
			return;
		int[][] sec = {{1,1},{1,0}};
		for(int i=2;i<=n;i++)
			multiply(feb,sec);
	}
	
	private void multiply(int[][] feb, int[][] sec)
	{
		int x = feb[0][0]*sec[0][0]+feb[0][1]*sec[1][0];
		int y = feb[0][0]*sec[0][1]+feb[0][1]*sec[1][1];
		int z = feb[1][0]*sec[0][0]+feb[1][1]*sec[1][0];
		int a = feb[1][0]*sec[0][1]+feb[1][1]*sec[1][1];
		feb[0][0]=x;
		feb[0][1]=y;
		feb[1][0]=z;
		feb[1][1]=a;
	}
	
	public int f4(int n)
	{
		if(n==0)
			return 0;
		int[][] feb = {{1,1},{1,0}};
		power_new_new(feb,n-1);
		return feb[0][0];
	}
	
	private void power_new_new(int[][] feb, int n)
	{
		if(n==0 || n==1)
			return;
		int[][] sec = {{1,1},{1,0}};
		power_new_new(feb,n/2);
		multiply(feb,feb);
		if(n%2!=0)
			multiply(feb,sec);
	}
	
}
 	