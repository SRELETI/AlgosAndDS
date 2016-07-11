
public class ConsArr {

	public void check(int[] arr)
	{
		int min = getMin(arr);
		int max = getMax(arr);
		
		if(max-min+1==arr.length)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[Math.abs(arr[i])-min]<0)
				{
					System.out.println("No it is not a consecutive array ");
					return;
				}
				else
					arr[Math.abs(arr[i])-min] = - arr[Math.abs(arr[i])-min];
			}
			System.out.println("It is a consecutive array ");
			return;
		}
		System.out.println("No it is not consecutive ");
	}
	
	private int getMin(int[] arr)
	{
		int min =arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<min)
				min = arr[i];
		}
		return min;	
	}
	
	private int getMax(int[] arr)
	{
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
	
	public static void main(String args[])
	{
		ConsArr c = new ConsArr();
		int[] arr = {7,6,5,5,3,4};
		c.check(arr);
	}
}
