
public class InterpolationSearch {
	private int[] arr;
	private int elements;
	
	public InterpolationSearch(int length)
	{
		arr= new int[length];
		elements=0;
	}
	
	public void add(int value)
	{
		arr[elements++] = value;
	}
	
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public int interpolationSearch(int key, int min, int max)
	{
		int low=0;
		int high=arr.length-1;
		while(true)
		{
			if(low>high || key < min || key > max)
				return -1;
			int guess;
			if(low==high)
				guess=high;
			else
			{
				int size=high-low;
				int offset = (int) (size-1)*(key-min)/(max-min);
				guess=low+offset;
			}
			if(arr[guess]==key)
				return guess;
			if(guess==0 || guess == arr.length-1)
				return -1;
			if(arr[guess]>key)
			{
				high=guess-1;
				max=arr[guess-1];
			}
			else
			{
				low=guess+1;
				min=arr[guess+1];
			}	
		}
	}
}
