import java.util.Arrays;


public class MergeSortExample {

	public void mergeSort(int[] arr)
	{
		if(arr.length<=1)
			return;
		int length = arr.length;
	//	int middle = length/2;
		int[] left = new int[length/2];
		int[] right = new int[length-length/2];
		for(int i=0;i<length/2;i++)
			left[i]=arr[i];
		for(int i=length/2;i<length;i++)
			right[i-length/2]=arr[i];
		mergeSort(left);
		mergeSort(right);
		merge(arr,left,right);
	}
	
	private void merge(int[] arr, int[] left, int[] right)
	{
		int i,j,k;
		i=0;
		j=0;
		k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			{
				arr[k]=left[i];
				i++;
			}
			else
			{
				arr[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<left.length)
		{
			arr[k]=left[i];
			k++;
			i++;
		}
		while(j<right.length)
		{
			arr[k]=right[j];
			k++;
			j++;
		}
	}
	
	public static void main(String args[])
	{
		MergeSortExample m = new MergeSortExample();
		int[] arr = {38,27,43,3,9,82,10};
		System.out.println("before sorting "+Arrays.toString(arr));
		m.mergeSort(arr);
		System.out.println("After sorting "+Arrays.toString(arr));
	}
}
