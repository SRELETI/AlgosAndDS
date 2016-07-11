
public class InterpolationSearchExample {

	public int inter(int[] arr, int low, int high, int value)
	{
		while(low<high)
		{
			int middle = low + ((high-low)/(arr[high]-arr[low]))*(value-arr[low]);
			if(arr[middle]==value)
				return middle;
			else if(arr[middle]<value)
				inter(arr,middle+1,high,value);
			else
				inter(arr,low,middle-1,value);
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		InterpolationSearchExample i = new InterpolationSearchExample();
		int[] arr = {91,92,93,94,95,96,97,98,99,100};
		System.out.println(i.inter(arr, 0, 9, 97));
	}
}
