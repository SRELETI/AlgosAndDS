
public class MinLen {

	public void minLen(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				min = i;
				break;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=arr.length-1;i>0;i--)
		{
			if(arr[i]<arr[i-1])
			{
				max = i;
				break;
			}
		}
		if(max == Integer.MIN_VALUE && min==Integer.MAX_VALUE)
		{
			System.out.println("Array is already sorted ");
			return;
		}
		
		int min_in = arr[min];
		int max_in = arr[min];
		for(int i=min+1;i<=max;i++)
		{
			if(arr[i]<min_in)
				min_in = arr[i];
			if(arr[i]>max_in)
				max_in = arr[i];
			
		}
		for(int i=0;i<min;i++)
		{
			if(arr[i]>min_in)
				min = i;
		}
	//	System.out.println(min_in +" "+max_in);
		for(int i=arr.length-1;i>max;i--)
		{
			if(arr[i]<max_in)
				max = i;
		}
		System.out.println("Start "+min+" End "+max);
	}
	
	public static void main(String args[])
	{
		int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		MinLen m = new MinLen();
		m.minLen(arr);
	}
}
