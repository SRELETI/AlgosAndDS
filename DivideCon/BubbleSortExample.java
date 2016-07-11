import java.util.Arrays;


public class BubbleSortExample {

	public void binary(int[] arr)
	{
		boolean flag;
		for(int i=0;i<arr.length;i++)
		{
			flag = true;
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					swap(arr,j,j+1);
					flag = false;
				}
			}
			if(flag == true)
				return;
		}
	}
	
	private void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b]= temp;
	}
	
	public static void main(String args[])
	{
		BubbleSortExample b = new BubbleSortExample();
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		System.out.println("before Sorting "+Arrays.toString(arr));
		b.binary(arr);
		System.out.println("After sorting "+Arrays.toString(arr));
	}
}
