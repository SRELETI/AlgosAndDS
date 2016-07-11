import java.util.Arrays;


public class QuickDiv {

	public void quick(int[] arr,int start, int end)
	{
		if(end-start<1)
			return;
		int pivot=findPivot(arr,start,end);
		quick(arr,start,pivot-1);
		quick(arr,pivot,end);
	}
	
	private int findPivot(int[] arr, int start, int end)
	{
		int pivot = end;
		int key = start;
		for(int i=start;i<end;i++)
		{
			if(arr[i]<arr[pivot])
			{
				swap(arr,i,key);
				key++;
			}
		}
		swap(arr,pivot,key);
		return key;
	}
	
	private void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
		
	}
	
	public static void main(String args[])
	{
		QuickDiv q = new QuickDiv();
		int[] arr ={10, 7, 8, 9, 1, 5};
		q.quick(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
	}
}
