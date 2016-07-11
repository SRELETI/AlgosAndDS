
public class Pivot {

	public int find(int[] arr, int element)
	{
		int pivot = findpivot(arr,0,arr.length-1);
	//	System.out.println(pivot);
		if(pivot==-1)
			return binarySearch(arr,0,arr.length-1,element);
		if(arr[pivot]==element)
			return pivot;
		else if(element>=arr[0])
			return binarySearch(arr,0,pivot-1,element);
		else 
			return binarySearch(arr,pivot+1,arr.length-1,element);
	}
	
	private int binarySearch(int[] arr, int start, int end, int element)
	{
		while(start<=end)
		{
			int mid = (start+end)/2;
			if(arr[mid]==element)
				return mid;
			else if(element>arr[mid])
				start = mid+1;
			else 
				end = mid-1;
		}
		return -1;
	}
	
	private int findpivot(int[] arr, int start, int end)
	{
		if(start>end)
			return -1;
		if(start==end)
			return start;
		int mid = (start+end)/2;
		if(mid<end && arr[mid]>arr[mid+1])
			return mid;
		else if(mid>start && arr[mid]<arr[mid-1])
			return mid-1;
		else if(arr[start]>arr[mid])
			return findpivot(arr,start,mid-1);
		else
			return findpivot(arr,mid+1,end);
	}
	
	public static void main(String args[])
	{
		int[] arr = {4,5,1,2,3};
		
		Pivot p = new Pivot();
		System.out.println(p.find(arr, 7));
	}
}
