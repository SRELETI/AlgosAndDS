
public class CountingSort {
	private int[] arr;
	private int elements;
	private int range;
	private int min;
	public CountingSort(int length, int maxRange)
	{
		arr = new int[length];
		elements=0;
		range=maxRange+1;
	}
	
	public CountingSort(int length, int minRange, int maxRange)
	{
		arr = new int[length];
		elements=0;
		min=minRange;
		range=maxRange;
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
	
	public void countingSort()
	{
		int length=range-min+1;
		int[] bucket = new int[length];
		for(int i=0;i<arr.length;i++)
		{
			bucket[arr[i]-min]++;
		}
		int out=0;
		for(int i=0;i<bucket.length;i++)
		{
			for(int j=0;j<bucket[i];j++)
			{
				arr[out++]=i+min;
			}
		}
	}
	
	public void countingSortNeg()
	{
		int length=range-min+1;
		int[] bucket = new int[length];
		for(int i=0;i<arr.length;i++)
		{
			bucket[arr[i]+Math.abs(min)]++;
		}
		int out=0;
		for(int i=0;i<bucket.length;i++)
		{
			for(int j=0;j<bucket[i];j++)
			{
				arr[out++]=i-Math.abs(min);
			}
		}
	}
}
