import java.util.Arrays;


public class SubOrNot {
	public static void main(String args[])
	{
		int[] arr = {10,5,2,23,19};
		int[] arr2 = {19,2,5};
		System.out.println(check(arr,arr2));
		System.out.println(check2(arr,arr2));
	}
	public static int check(int[] arr, int[] arr2)
	{
		int j;
		for(int i=0;i<arr2.length;i++)
		{
			for(j=0;j<arr.length;j++)
			{
				if(arr[j]==arr2[i])
					break;
			}
			if(j==arr.length)
				return -1;
		}
		return 0;
	}
	public static int check2(int[] arr, int[] arr2)
	{
		Arrays.sort(arr);
		for(int i=0;i<arr2.length;i++)
		{
			if(binary_search(arr,0,arr.length-1,arr2[i])==-1)
				return -1;
		}
		return 0;
	}
	public static int binary_search(int[] arr, int start, int end, int element)
	{
		while(start<=end)
		{
			int middle=start+(end-start)/2;
			if(arr[middle]==element)
				return 0;
			else if(arr[middle]>element)
				end=middle-1;
			else
				start=middle+1;
		}
		return -1;
	}
}
