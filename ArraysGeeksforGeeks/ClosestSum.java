import java.util.Arrays;


public class ClosestSum {

	public void closest(int[] arr)
	{
		Arrays.sort(arr);
		int sum;
		int min_sum=Integer.MAX_VALUE;
		int start=0;
		int end = arr.length-1;
		while(start<end)
		{
			sum = arr[start]+arr[end];
			if(Math.abs(sum)<Math.abs(min_sum))
				min_sum = sum;
			if(sum>0)
				start++;
			else
				end--;
		}
		System.out.println(min_sum);
	}
	
	public static void main(String args[])
	{
		ClosestSum c = new ClosestSum();
		int[] arr = {12,13,1,10,34,1};
	//	c.closest(arr);
		c.firstSec(arr);
	}
	
	public void firstSec(int[] arr)
	{
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<first)
			{
				second = first;
				first = arr[i];
			}
			else if(arr[i]<second && arr[i]!=first)
				second = arr[i];
		}
		
		System.out.println("The first one is "+first +" and second is "+second);
	}
}
