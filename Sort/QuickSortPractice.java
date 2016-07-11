
public class QuickSortPractice {
	public int[] arr;
	private int elements;
	public QuickSortPractice(int length)
	{
		arr = new int[length];
		elements=0;
	}
	
	public void add(int value)
	{
		arr[elements++]=value;
	}
	
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void quick(int left, int right)
	{
		if(left<right)
		{
			int pIndex=partition(left, right);
			quick(left,pIndex-1);
			quick(pIndex+1,right);
		}
	}
	
	public int partition(int left, int right)
	{
		int pivot=arr[right];
		int pIndex=left;
		for(int i=left;i<right;i++)
		{
			if(arr[i]<pivot)
			{
				int temp=arr[i];
				arr[i]=arr[pIndex];
				arr[pIndex]=temp;
				pIndex++;
			}
		}
		int temp=arr[pIndex];
		arr[pIndex]=arr[right];
		arr[right]=temp;
		return pIndex;
	}
}
