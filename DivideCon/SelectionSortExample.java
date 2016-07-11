import java.util.Arrays;


public class SelectionSortExample {

	public void selection(int[] arr)
	{
		int min;
		for(int i=0;i<arr.length-1;i++)
		{
			min = i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr,i,min);
		}
	}
	
	private void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a]= arr[b];
		arr[b]= temp;
	}
	public static void main(String args[])
	{
		SelectionSortExample s = new SelectionSortExample();
		int[] arr ={64,25,12,22,11};
		System.out.println("Before sorting "+Arrays.toString(arr));
		s.selection(arr);
		System.out.println("After Sorting "+Arrays.toString(arr));
		
	}
}
