
public class QuickSortArr {
	public int[] arr;
	private int elements;
	public QuickSortArr(int length)
	{
		arr = new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void quickSort(int[] arr2, int start, int end)
	{
		if(start<end)
		{
			int pIndex = partition(arr2,start,end);
			quickSort(arr2,start,pIndex-1);
			quickSort(arr2,pIndex+1,end);
		}
	}
	public int partition(int[] arr2, int start, int end)
	{
		int pivot=arr[end];
		int pIndex=start;
		for(int i=start;i<end;i++)
		{
			if(arr[i]<=pivot)
			{
				int temp=arr[i];
				arr[i]=arr[pIndex];
				arr[pIndex]=temp;
				pIndex++;
			}
		}
		int temp=arr[pIndex];
		arr[pIndex]=arr[end];
		arr[end]=temp;
		return pIndex;
	}
}
