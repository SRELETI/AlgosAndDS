import java.util.Arrays;


public class OnceElement {
	public static void main(String args[])
	{
		int[] arr = {12, 1, 12, 2, 12, 1, 1, 2, 2, 3};
		//element(arr);
		once(arr);
		once_eff(arr);
	}
	public static void element(int[] arr)
	{
		System.out.println(Integer.SIZE);
		Arrays.sort(arr);
		if(arr.length==1)
		{
			System.out.println("The element occuring once is "+arr[0]);
			return;
		}
		if(arr[0]!=arr[1])
		{
			System.out.println("The element occuring once is "+arr[0]);
			return;
		}
		if(arr[arr.length-1]!=arr[arr.length-2])
		{
			System.out.println("The element occuring once is "+arr[arr.length-1]);
			return;
		}
		for(int i=1;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1])
			{
				System.out.println("The element occuring once is "+arr[i]);
				return;
			}
		}
		
	}
	public static void once(int[] arr)
	{
		int one=0; 
		int two=0;
		for(int i=0;i<arr.length;i++)
		{
			two=two | (one & arr[i]);
			one=one ^ arr[i];
			int common_mask=~(one & two);
			one=one&common_mask;
			two=two&common_mask;
		}
		System.out.println(one);
	}
	public static void once_eff(int[] arr)
	{
		int result=0;
		for(int i=0;i<Integer.SIZE;i++)
		{
			int sum=0;
			int x=1<<i;
			for(int j=0;j<arr.length;j++)
			{
				if((arr[j] & x) !=0)
					sum++;
			}
			if(sum%3!=0)
				result=result | x;
		}
		System.out.println(result);
	}
}
