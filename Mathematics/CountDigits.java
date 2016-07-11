import java.util.Arrays;


public class CountDigits {

	public void count(int[] arr)
	{
		if(arr.length==0)
			return;
		int i=arr.length-1;
		for(int j=i-1;j>=0;j--)
		{
			if(arr[j]<arr[i])
			{
				swap(arr,j,i);
				Arrays.sort(arr, j+1, arr.length);
				System.out.println(Arrays.toString(arr));
				return;
			}
		}
		
		System.out.println("Not Possible ");
	}
	private void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a]= arr[b];
		arr[b]=temp;
	}
	
	public static void main(String args[])
	{
		CountDigits c = new CountDigits();
		int[] arr = {5,3,4,9,7,6};
		c.count(arr);
	}
}
