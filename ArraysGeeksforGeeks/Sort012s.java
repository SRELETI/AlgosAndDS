import java.util.Arrays;


public class Sort012s {

	public void sort(int[] arr)
	{
		int low = 0;
		int mid =0;
		int high=arr.length-1;
		while(mid<=high)
		{
			if(arr[mid]==0)
			{
				swap(arr,low,mid);
				low++;
				mid++;
			}
			else if(arr[mid]==2)
			{
				swap(arr,high,mid);
				high--;
			}
			else
				mid++;	
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int[] arr, int low, int end)
	{
		int temp = arr[low];
		arr[low] = arr[end];
		arr[end] = temp;
	}
	
	public static void main(String args[])
	{
		int[] arr = {0,1,1,0,1,2,1,2,0,0,0,1};
		Sort012s d = new Sort012s();
		d.sort(arr);
	}
}
