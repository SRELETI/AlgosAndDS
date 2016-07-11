import java.util.Arrays;


public class SmallRight {
	public static void main(String args[])
	{
		int[] arr = {1, 2, 3, 4, 5};
		small(arr);
	}
	public static void small(int[] arr)
	{
		int[] count_arr = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			int count=0;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[i])
				{
					count++;
				}
			}
			count_arr[i]=count;
		}
		System.out.println(Arrays.toString(count_arr));
	}
}
