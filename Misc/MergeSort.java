import java.util.*;
public class MergeSort {
	public int[] merge_sort(int[] arr)
	{
		if(arr.length<=1)
			return arr;
		int left[]=new int[arr.length/2];
		int right[]=new int[arr.length-left.length];
		for(int i=0;i<left.length;i++)
		{
			left[i]=arr[i];
		}
		for(int j=0;j<right.length;j++)
		{
			right[j]=arr[j+left.length];
		}
		merge_sort(left);
		merge_sort(right);
		merge(arr,left,right);
		return arr;
	}
	public void merge(int[] arr,int[] left,int[] right)
	{
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			{
				arr[k]=left[i];
				i++;
				k++;
			}
			else
			{
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<left.length)
		{
			arr[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length)
		{
			arr[k]=right[j];
			j++;
			k++;
		}
	}
	public static void main(String args[])
	{
		int arr[]={3,2,7,4,1,6};
		MergeSort ms=new MergeSort();
		int arr2[]=ms.merge_sort(arr);
		System.out.println(Arrays.toString(arr2));
	}
}
