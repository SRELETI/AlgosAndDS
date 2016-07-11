
public class MissingNumber1 {
	public static void main(String args[])
	{
		int[] arr = {0,1,2,4};
		System.out.println(missing(arr));
		System.out.println(missing2(arr));
		System.out.println(missing3(arr,0,3));
		
	}
	public static int missing(int[] arr)
	{
		if(arr[0]!=0)
			return 0;
		int i;
		for(i=1;i<arr.length;i++)
		{
			if(arr[i]-arr[i-1]!=1)
				return arr[i-1]+1;
		}
		return arr[arr.length-1]+1;
		
	}
	public static int missing2(int[] arr)
	{
		if(arr[0]!=0)
			return 0;
		int i;
		for( i=1;i<arr.length;i++)
		{
			if(arr[i]!=i)
				return arr[i-1]+1;
		}
		return arr[arr.length-1]+1;
	}
	public static int missing3(int[] arr, int start, int end)
	{
		if(start>end)
			return end+1;
		if(arr[start]!=start)
			return start;
		int middle=start+(end-start)/2;
		if(arr[middle]>middle)
			return missing3(arr,start,middle);
		else
			return missing3(arr,middle+1,end);
	}
}
