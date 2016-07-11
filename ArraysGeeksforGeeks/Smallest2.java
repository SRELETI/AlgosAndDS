
public class Smallest2 {
	public static void second(int[] arr)
	{
		int smallest=Integer.MIN_VALUE;
		int second_smallest=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>smallest)
			{
				second_smallest=smallest;
				smallest=arr[i];
			}
			if(arr[i]>second_smallest && arr[i] != smallest)
				second_smallest=arr[i];
		}
		System.out.println("The elements are" +smallest+ " "+ second_smallest);
	}
	public static void main(String args[])
	{
		int[] arr = {3,4,5,2,7,1};
		second(arr);
	}
}
