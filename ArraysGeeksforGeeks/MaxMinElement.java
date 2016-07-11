
public class MaxMinElement {
	public static void main(String args[])
	{
		int[] arr= {1,2,3};
		//maxMin(arr);
		modified_maxMin(arr);
	}
	public static void maxMin(int arr[])
	{
		int max;
		int min;
		if(arr.length==1)
		{
			max=arr[0];
			min=arr[0];
			System.out.println(max+ " "+ min);
			return;
		}
		if(arr.length==2)
		{
			if(arr[1]>arr[0])
			{	
				max=arr[1];
				min=arr[0];
				System.out.println(max+" "+min);
				return;
			}
			else if(arr[1]<arr[0])
			{
				max=arr[0];
				min=arr[1];
				System.out.println(max+ " "+ min);
				return;
			}
			else
			{
				max=min=arr[0];
				System.out.println(max+ " "+ min);
				return;
			}
		}
		if(arr.length>2)
		{
			if(arr[1]>arr[0])
			{
				min=arr[0];
				max=arr[1];
			}
			else
			{
				max=arr[0];
				min=arr[1];
			}
			for(int i=2;i<arr.length;i++)
			{
				if(arr[i]<min)
					min=arr[i];
				if(arr[i]>max)
					max=arr[i];
			}
			System.out.println(max+" "+min);
			return;
		}
	}
	public static void modified_maxMin(int[] arr)
	{
		int min,max;
		int n=arr.length;
		int i;
		if(n%2==0)
		{
			if(arr[1]>arr[0])
			{
				min=arr[0];
				max=arr[1];
			}
			else
			{
				min=arr[1];
				max=arr[0];
			}
			i=2;
		}
		else
		{
			min=arr[0];
			max=arr[1];
			i=1;
		}
		while(i<n-1)
		{
			if(arr[i]>arr[i+1])
			{
				if(arr[i]>max)
					max=arr[i];
				if(arr[i]<min)
					min=arr[i];
			}
			else
			{
				if(arr[i+1]>max)
					max=arr[i+1];
				if(arr[i]<min)
					min=arr[i];
			}
			i=i+2;
		}
		System.out.println(min+" "+max);
	}
	
}
