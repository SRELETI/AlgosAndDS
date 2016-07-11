
public class MinSubArrSort {
	private int[] arr;
	private int elements;
	
	public MinSubArrSort(int length)
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
	
	public void sort()
	{
		int start=0;
		int end=arr.length-1;
		for(int i=0;i+1<arr.length;i++)
		{
			if(arr[i]>arr[i+1])
			{
				start=i;
				break;
			}
		}
		for(int i=arr.length-1;i-1>=0;i--)
		{
			if(arr[i]<arr[i-1])
			{
				end=i;
				break;
			}
		}
		int min=arr[start];
		int max=arr[start];
		for(int i=start;i<=end;i++)
		{
			if(arr[i]<min)
				min=arr[i];
			if(arr[i]>max)
				max=arr[i];
		}
		
		for(int i=0;i<start;i++)
		{
			if(arr[i]>min)
			{
				start=i;
				break;
			}
		}
		
		for(int i=arr.length-1;i>end;i--)
		{
			if(arr[i]<max)
			{
				end=i;
				break;
			}
		}
		System.out.println("The maximum unsorted subarray is "+start+" "+ end);
	}
}
