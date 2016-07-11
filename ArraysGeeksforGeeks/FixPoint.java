
public class FixPoint {

	public void fix(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		int result = cal(arr,start,end);
		System.out.println(result!=0 ? "Yes found an index at "+result : "No Not found any such indexes ");
	}
	
	private int cal(int[] arr, int start, int end)
	{
		if(start>end)
			return -1;
		int middle = (start+end)/2;
		if(arr[middle]==middle)
			return middle;
		else if(arr[middle]>middle)
			return cal(arr,start,middle-1);
		else 
			return cal(arr,middle+1,end);
	}
	
	public static void main(String args[])
	{
		int[] arr = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
		FixPoint f = new FixPoint();
		f.fix(arr);
	}
}
