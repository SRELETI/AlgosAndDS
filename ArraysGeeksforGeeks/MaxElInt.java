
public class MaxElInt {
	public static void main(String args[])
	{
		int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		max(arr);
		System.out.println(max_rec(arr,0,arr.length-1));
	}
	public static void max(int[] arr)
	{
		if(arr.length<3)
		{
			System.out.println("No such element ");
			return;
		}
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[i-1])
			{
				System.out.println("The element is "+ arr[i-1]);
				return;
			}
		}
	}
	public static int max_rec(int[] arr, int start, int end)
	{
		if(start==end)
			return arr[start];
		if(end==start+1 && arr[end]>arr[start])
			return arr[end];
		if(end==start+1 && arr[start]>=arr[end])
			return arr[start];
		int middle=start+(end-start)/2;
		if(arr[middle]>arr[middle-1] && arr[middle]>arr[middle+1])
			return arr[middle];
		else if(arr[middle]>arr[middle+1] && arr[middle]<arr[middle-1])
			return max_rec(arr,start,middle-1);
		else
			return max_rec(arr,middle+1,end);
	}
}
