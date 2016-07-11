import java.util.Arrays;


public class MergeDiv {

	public void mergeSort(int[] arr)
	{
		if(arr.length<=1)
			return;
		int middle = arr.length/2;
		int[] left = new int[middle];
		int[] right = new int[arr.length-middle];
		int i;
		for(i=0;i<middle;i++)
			left[i]=arr[i];
		for(i=middle;i<arr.length;i++)
			right[i-middle]=arr[i];
		mergeSort(left);
		mergeSort(right);
		merge(left,right,arr);
	}
	
	private void merge(int[] left, int[] right, int[] arr)
	{
		int i=0,j=0,k=0;
		int l_length = left.length;
		int r_length = right.length;
		while(i<l_length && j<r_length)
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
		while(i<l_length)
		{
			arr[k++]=left[i++];
		}
		while(j<r_length)
		{
			arr[k++]=right[j++];
		}
	}
	
	public static void main(String args[])
	{
		MergeDiv m = new MergeDiv();
		int[] arr = {5,4,2,1,3};
		System.out.println("before sorting "+Arrays.toString(arr));
		m.mergeSort(arr);
		System.out.println("After sorintg "+Arrays.toString(arr));
	}
}
