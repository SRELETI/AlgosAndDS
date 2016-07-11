import java.util.Arrays;


public class KLargest {
	public static int[] largest(int arr[],int k)
	{
		for(int i=0;i<k;i++)
		{
			for(int j=1;j<arr.length-i;j++)
			{
				if(arr[j-1]>arr[j])
				{
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public static void display(int arr[],int k)
	{
		for(int i=arr.length-1;i>k;i--)
		{
			System.out.println(arr[i]);
		}
	}
	public static void modified_method(int[] arr, int k)
	{
		Arrays.sort(arr);
		for(int i=arr.length-1;i>k;i--)
			System.out.println(arr[i]);
	}
	public static void main(String args[])
	{
		int[] arr= {2,3,6,4,1};
		int k=2;
		modified_method(arr,2);
		/*int arr2[]=largest(arr,k);
		System.out.println(Arrays.toString(arr2));
		display(arr2,2);*/
	}
}
