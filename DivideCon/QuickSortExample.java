import java.util.Arrays;


public class QuickSortExample {

	public void quickSort(int[] arr, int left, int right)
	{
		if(left<right)
		{
			int pivot = findPivot(arr,left,right);
			quickSort(arr,left,pivot-1);
			quickSort(arr,pivot+1,right);
		}
	}
	
	private int findPivot(int[] arr, int left, int right)
	{
		int pivot = right;
		int i=left;
		int j=left;
		for(j=left;j<right;j++)
		{
			if(arr[j]<arr[pivot])
			{
				swap(arr,j,i);
				i++;
			}
		}
		swap(arr,i,pivot);
		return i;
	}
	
	private void swap(int[] arr, int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void main(String args[])
	{
		QuickSortExample q = new QuickSortExample();
		int[] arr = {10, 7, 8, 9, 1, 5};
		System.out.println("Before sorting "+Arrays.toString(arr));
		q.quickSort(arr, 0, arr.length-1);
		System.out.println("After Sorting "+Arrays.toString(arr));
	}
}
