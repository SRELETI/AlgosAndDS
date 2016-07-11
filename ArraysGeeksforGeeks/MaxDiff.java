
public class MaxDiff {

	public static void main(String args[])
	{
		int[] arr={1,2,90,10,110};
		max_mod(arr);
		
	}
	public static void max(int arr[])
	{
		int max=arr[1]-arr[0];
		int largest=1;
		int smallest=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]-arr[i]>max)
				{
					max=arr[j]-arr[i];
					largest=j;
					smallest=i;
				}
			}
		}
		System.out.println("The max diff is "+max+" with the largest element at index "+largest+" and smallest at index "+smallest);
	}
	public static void max_mod(int arr[])
	{
		int max=arr[1]-arr[0];
		int min_element=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-min_element>max)
				max=arr[i]-min_element;
			if(arr[i]<min_element)
				min_element=arr[i];
		}
		System.out.print(max);
	}
}
