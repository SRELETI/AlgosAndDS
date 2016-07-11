
public class Combinations {

	public void comb(String s, String result)
	{
		if(s.length()==result.length())
		{
			System.out.println(result);
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			comb(s,result+s.charAt(i));
		}
	}
	
	public static void main(String args[])
	{
		Combinations c = new Combinations();
		String s="AB";
		String result="";
	//	c.comb(s, result);
		int[] arr = new int[50];
	//	c.comb1(3, 0, arr);
		c.power(5, 4);
		System.out.println(c.power_rec(5, 4));
	}
	
	public void comb1(int n, int index,int[] arr)
	{
		if(n==0)
		{
			printArray(arr,index);
			return;
		}
		else if(n>0)
		{
			for(int i=1;i<=3;i++)
			{
				arr[index]=i;
				comb1(n-i,index+1,arr);
			}
		}
	}
	
	private void printArray(int[] arr, int index)
	{
		for(int i=0;i<index;i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	
	private void power(int a,int b)
	{
		if(b==0)
		{
			System.out.println(1);
			return;
		}
		int ans = a;
		int inc = a;
		for(int i=0;i<b-1;i++)
		{
			for(int j=0;j<a-1;j++)
			{
				ans = ans + inc;
			}
			inc = ans;
		}
		System.out.println(ans);
	}
	
	private int power_rec(int a, int b)
	{
		if(b!=0)
			return mult(a,power_rec(a,b-1));
		else 
			return 1;
	}
	
	private int mult(int a, int b)
	{
		if(b==0)
			return 0;
		else
			return a+(mult(a,b-1));
	}
}
