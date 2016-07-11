
public class MinAndMax {

	public void find(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		if(arr.length==1)
		{
			min = arr[0];
			max = arr[1];
			System.out.println(min+" "+max);
			return;
		}
		if(arr[0]>arr[1])
		{
			min = arr[1];
			max = arr[0];
		}
		else if(arr[0]<arr[1])
		{
			min = arr[0];
			max = arr[1];
		}
		
		for(int i=2;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];
			else if(arr[i]<min)
				min = arr[i];
		}
		System.out.println(min+" "+max);
	}
	

}
