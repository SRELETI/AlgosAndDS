
public class FindPeakElement {

	public int peak(int[] arr, int low, int high)
	{
		int middle = (low+high)/2;
		if((middle==0 || arr[middle-1]<=arr[middle]) && (middle ==arr.length-1 || arr[middle+1]<=arr[middle]))
			return arr[middle];
		if(middle>0 && arr[middle]>arr[middle-1])
			return peak(arr,middle+1,high);
		else
			return peak(arr,low,middle-1);
	}
	
	public static void main(String args[])
	{
		int[] arr = {100, 80, 60, 50, 20};
		FindPeakElement f = new FindPeakElement();
		System.out.println(f.peak(arr, 0, arr.length-1));
	}
}
