import java.util.Arrays;


public class Practice {

	public void once(int[] arr)
	{
		int result = 0;
		int sum,j;
		for(int i=0;i<Integer.SIZE;i++)
		{
			sum=0;
			j=1<<i;
			for(int k=0;k<arr.length;k++)
			{
				if((arr[k]&j)!=0)
					sum++;
			}
			if(sum%3!=0)
				result =result | j;
		}
		System.out.println(result);
	}
	public static void main(String args[])
	{
		Practice p = new Practice();
		int[] arr = {12,1,12,3,12,1,1};
	//	p.once(arr);
	//	p.opp(1, 2);
	//	p.setBits(8);
	//	p.swap(28, 0, 3, 2);
	//	p.add(2, 5);
	//	p.smallest(12, 15, 5);
	//	p.smallest2(12, 15, 5);
	//	p.largest(12, 15, 5);
		int[] x = {1,0};
		int[] y ={0,1};
	//	p.bool_arr(x, y);
	//	p.add_1(6);
	//	p.mul_35(5);
	//	p.right_off(7);
	//	p.power_4(16);
		p.abs(-2);
	}
	
	public void left_rotate(int x,int d)
	{
		int result = (x<<d) | (x>>(Integer.SIZE-d));
	}
	public void power_4(int x)
	{
		if((x&(x-1))==0)
		{
			int count=0;
			while(x>1)
			{
				x=x>>1;
				count++;
			}
			System.out.println(count);
			if(count%2==0)
			{
				System.out.println("it is a power of 4");
				return;
			}
			else
			{
				System.out.println("not a power of 4");
				return;
			}
		}
		else
		{
			System.out.println("not a power of 4");
		}
	}
	
	public void abs(int x)
	{
		int mask = x>>31;
		int result = (mask+x)^mask;
		System.out.println(result);
	}
	public void right_off(int x)
	{
		int result = x &(x-1);
		System.out.println(result);
	}
	public void add_1(int x)
	{
		int m=1;
		while((x&1)!=0)
		{
			x =x^m;
			m=m<<1;
		}
		x= x^m;
		System.out.println(x);
	}
	private void mul_35(int x)
	{
		int result = (x<<1)+x+(x>>1);
		System.out.println(result);
	}
	public void bool_arr(int[] x,int[] y)
	{
		x[x[1]]=x[x[0]];
		y[0]=y[y[0]];
		y[1]=y[0];
		System.out.println(Arrays.toString(x)+" "+Arrays.toString(y));
	}
	public void smallest(int x, int y, int z)
	{
		int count = 0;
		while(x!=0 && y!=0 && z!=0)
		{
			x= x-1;
			y=y-1;
			z=z-1;
			count++;
		}
		System.out.println(count);
	}
	
	public void smallest2(int x, int y, int z)
	{
		int result = min(x,min(y,z));
		System.out.println(result);
	}
	public void largest(int x, int y, int z)
	{
		int result = max(x,max(y,z));
		System.out.println(result);
	}
	
	private int min(int x, int y)
	{
		return y+((x-y) & ((x-y)>>31));
	}
	private int max(int x, int y)
	{
		return x-((x-y) &((x-y)>>31));
	}
	
	public int sub(int x, int y)
	{
		int result = add(x,add(~y,1));
	//	System.out.println(result);
		return result;
	}
	
	public int div(int x, int y)
	{
		int mask= 0x1;
		int quo=0;
		while(y<=x)
		{
			y = y<<1;
			mask = mask<<1;
		}
		
		while(mask>1)
		{
			y = y>>1;
			mask = mask>>1;
			if(x>=y)
			{
				x = x -y;
				quo = quo | mask;
			}
		}
		return quo;
	}
	public int mul(int x, int y)
	{
		int a=x;
		for(int i=1;i<y;i++)
		{
			a= add(a,x);
			
		}
		return a;
	}
	
	
	public int add(int x, int y)
	{
		int carry;
		while(y!=0)
		{
			carry = x&y;
			x = x^y;
			y=carry<<1;
		}
		return x;
	}
	
	public void opp(int x, int y)
	{
		int result = x^y;
		if(result<0)
			System.out.println("Oppsite sign");
		else
			System.out.println("Same Sign");
	}
	
	public void setBits(int x)
	{
		int sum=0;
		int j;
		for(int i=0;i<Integer.SIZE;i++)
		{
			j=1<<i;
			for(int k=1;k<=x;k++)
			{
				if((k&j)!=0)
					sum++;
			}
		}
		System.out.println(sum);
	}
	
	
	public void swap(int x, int left, int right,int d)
	{
		int set1 = (x>>left & ((1<<d)-1));
		int set2 = (x>>right & ((1<<d)-1));
		int xor = set1 ^ set2;
		xor = xor<<left | xor<<right;
		System.out.println(xor^x);
	}
}
