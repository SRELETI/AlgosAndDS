
public class FibPow {

	public int pow(int x, int y)
	{
		if(y==0)
			return 1;
		if(y%2==0)
			return pow(x,y/2)*pow(x,y/2);
		else
			return x*pow(x,y/2)*pow(x,y/2);
	}
	
	public int pow2(int x, int y)
	{
		if(y==0)
			return 1;
		int temp = pow2(x,y/2);
		if(y%2==0)
			return temp*temp;
		else
			return x*temp*temp;
	}
	
	public int pow3(int x, int y)
	{
		if(y==0)
			return 1;
		int temp = pow3(x,y/2);
		if(y%2==0)
			return temp*temp;
		else
		{
			if(y>0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}
	
	public int pow_noStand(int x, int y)
	{
		if(y==0)
			return 1;
		int ans = x;
		int inc = x;
		for(int i=1;i<y;i++)
		{
			for(int k=1;k<x;k++)
			{
				ans = ans+inc;
			}
			inc = ans;
		}
		return ans;
	}
	
	public int pow_rec(int x, int y)
	{
		if(y==0)
			return 1;
		return mult(x,pow_rec(x,y-1));
	}
	
	private int mult(int x, int y)
	{
		if(y==0)
			return 0;
		return x+mult(x,y-1);
	}
	
	public static void main(String args[])
	{
		FibPow f = new FibPow();
	/*	System.out.println(f.pow(2, 5));
		System.out.println(f.pow2(2, 5));
		System.out.println(f.pow3(2, 5));
		System.out.println(f.pow_noStand(2, 5));
		System.out.println(f.pow_rec(2, 5));
		*/
		System.out.println(f.fib(0));
		System.out.println(f.fib_dp(0));
		System.out.println(f.fib_dp_opt(0));
		System.out.println(f.fib_ser(0));
		System.out.println(f.fib_pow_mat(0));
		
	}
	
	public int fib(int n)
	{
		if(n<=1)
			return n;
		return fib(n-1)+fib(n-2);
	}
	
	public int fib_dp(int n)
	{
		if(n<=1)
			return n;
		int[] f = new int[n+1];
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=n;i++)
		{
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}
	
	public int fib_dp_opt(int n)
	{
		if(n<=1)
			return n;
		int a=0;
		int b=1;
		int c;
		for(int i=2;i<=n;i++)
		{
			c = a+b;
			a=b;
			b=c;
		}
		return b;
	}
	
	public int fib_pow_mat(int n)
	{
		if(n<=0)
			return n;
		int[][] fib = {{1,1},{1,0}};
		power(fib,n-1);
		return fib[0][0];
	}
	
	private void power(int[][] fib, int n)
	{
		if(n==0 || n==1)
			return;
		int[][] sec = {{1,1},{1,0}};
		for(int i=2;i<=n;i++)
		{
			multiply(fib,sec);
		}
	}
	
	private void multiply(int[][] fib, int[][] sec)
	{
		int x = fib[0][0]*sec[0][0]+fib[0][1]*sec[1][0];
		int y = fib[0][0]*sec[0][1]+fib[0][1]*sec[1][1];
		int z = fib[1][0]*sec[0][0]+fib[1][1]*sec[1][0];
		int a = fib[1][0]*sec[0][1]+fib[1][1]*sec[1][1];
		
		fib[0][0]=x;
		fib[0][1]=y;
		fib[1][0]=z;
		fib[1][1]=a;
	}
	
	public int fib_ser(int n)
	{
		if(n<=1)
			return n;
		int[][] fib = {{1,1},{1,0}};
		power_mod(fib,n-1);
		return fib[0][0];
	}
	
	private void power_mod(int[][] fib, int n)
	{
		if(n<=1)
			return;
		power_mod(fib,n/2);
		int[][] sec = {{1,1},{1,0}};
		multiply(fib,fib);
		if(n%2!=0)
			multiply(fib,sec);
	}
}
