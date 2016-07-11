
public class Occ {

	public void count(int[] arr, int element)
	{
		int first = binarySearch(arr,element,0,arr.length-1);
		int last = binaryLast(arr,element,0,arr.length-1);
		if(first==-1 && last ==-1)
			System.out.println("Not found ");
		else
			System.out.println(last-first+1);
	}
	
	private int binarySearch(int[] arr, int element,int start, int end)
	{
		if(start>end)
			return -1;
		if(arr[start]==element)
			return start;
		int middle = start+(end-start)/2;
		if(middle>start && arr[middle-1]!=element && arr[middle]==element)
			return middle;
		if(arr[middle]<element)
			return binarySearch(arr,element,middle+1,end);
		else 
			return binarySearch(arr,element,start,middle-1);
	}
	
	private int binaryLast(int[] arr,int element, int start, int end)
	{
		if(start>end)
			return -1;
		if(arr[end]==element)
			return end;
		int middle = start + (end-start)/2;
		if(middle<end && arr[middle]==element && arr[middle+1]!=element)
			return middle;
		if(arr[middle]>element)
			return binaryLast(arr,element,start,middle-1);
		else
			return binaryLast(arr,element,middle+1,end);
	}
	
	public static void main(String args[])
	{
		int[] arr = {1,1,2,2,2,2,3};
		Occ o = new Occ();
		o.count(arr, 4);
	}
	
	public void check(int[] arr)
	{
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			left[i] = Math.min(arr[i], left[i-1]);
		}
		
		right[arr.length-1] = arr[arr.length-1];
		for(int j=arr.length-2;j>=0;j--)
		{
			right[j] = Math.max(arr[j], right[j+1]);
		}
		
		int i=0;
		int j=0;
		int max_diff = -1;
		while(i<arr.length && j<arr.length)
		{
			if(left[i]<right[j])
			{
				max_diff = Math.max(max_diff, j-i);
				j = j+1;
			}
			else
				i = i+1;
		}
	}
}
