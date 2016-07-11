import java.util.Arrays;


public class InsertionSortRecursive {
	public static void main(String args[])
	{
		int arr[]={6,4,5,2,3,1};
		InsertionSortRecursive isr=new InsertionSortRecursive();
		isr.sorting(arr.length,arr);
		System.out.print(Arrays.toString(arr));
	}
	public int sorting(int index,int[] arr)
	{
		if(index<=1)
		{
			return index;
		}
		index=sorting(index-1,arr);
		int key=arr[index];
		int i=index-1;
		while(i>=0 && arr[i]>key)
		{
			arr[i+1]=arr[i];
			i=i-1;
		}
		arr[i+1]=key;
		return index+1;
	}
}
