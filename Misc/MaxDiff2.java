
public class MaxDiff2 {
	public static void main(String args[])
	{
		int[] arr= {2,3,10,17,18};
		//max_diff(arr);
		//max_diff2(arr);
		//System.out.println(ceil(arr,17));
		//System.out.println(ceil_rec(arr,0,arr.length-1,18));
		System.out.println(floor(arr,2));
		System.out.println(floor_rec(arr,0,arr.length-1,2));
	}
	public static void max_diff(int arr[])
	{
		int min_sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]-arr[i]>min_sum)
					min_sum=arr[j]-arr[i];
			}
		}
		System.out.println(min_sum);
	}
	public static void max_diff2(int[] arr)
	{
		int min_sum=arr[1]-arr[0];
		int min_element=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]-min_element>min_sum)
				min_sum=arr[i]-min_element;
			if(arr[i]<min_element)
				min_element=arr[i];
		}
		System.out.println(min_sum);
	}
	public static int ceil(int[] arr, int x)
	{
		if(x<arr[0])
			return arr[0];
		if(x>=arr[arr.length-1])
			return -1;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==x)
				return arr[i+1];
			if(arr[i]<=x && arr[i+1]>x)
				return arr[i+1];
		}
		return -1;
	}
	public static int floor(int[] arr, int x)
	{
		if(x>arr[arr.length-1])
			return arr[arr.length-1];
		if(x<=arr[0])
			return -1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==x)
				return arr[i-1];
			if(x<=arr[i] && x> arr[i-1])
				return arr[i-1];
		}
		return -1;
	}
	public static int ceil_rec(int[] arr, int start, int end, int x)
	{
		if(x<arr[start])
			return arr[start];
		if(x>=arr[end])
			return -1;
		int middle=start+(end-start)/2;
		if(arr[middle]==x)
			return arr[middle+1];
		else if(arr[middle]<x)
		{
			if(middle+1<arr.length && arr[middle+1]>x)
				return arr[middle+1];
			else
				return ceil_rec(arr,middle+1,end,x);
		}
		else
		{
			if(middle-1>=0 && arr[middle-1]<=x)
				return arr[middle];
			else
				return ceil_rec(arr,start,middle-1,x);
		}
	}
	public static int floor_rec(int[] arr, int start, int end, int x)
	{
		if(x>arr[arr.length-1])
			return arr[end];
		if(x<=arr[start])
			return -1;
		int middle=start+(end-start)/2;
		if(arr[middle]==x)
			return arr[middle-1];
		else if(arr[middle]<x)
		{
			if(middle+1<=arr.length-1 && arr[middle+1]>=x)
				return arr[middle];
			else 
				return floor_rec(arr,middle+1,end,x);
		}
		else
		{
			if(middle-1>=0 && arr[middle-1]<=x)
				return arr[middle-1];
			else
				return floor_rec(arr,start,middle-1,x);
		}
	}
	
}
