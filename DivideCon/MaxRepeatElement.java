import java.util.Arrays;


public class MaxRepeatElement {

	public void max(int[] arr, int k, int n)
	{
		
		for(int i=0;i<arr.length;i++)
		{
			arr[arr[i]%k] += k;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]/n >= max)
			{
			//	System.out.println(arr[i]%k);
				max = arr[i]/n;
			}
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]/n == max)
			{
				System.out.println("The max repeating element "+i);
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = arr[i]%k;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[])
	{
		int[] arr = {2, 3, 3, 5, 3, 2, 2, 7};
		MaxRepeatElement m = new MaxRepeatElement();
		m.max(arr, 8, 8);
		
	}
}
