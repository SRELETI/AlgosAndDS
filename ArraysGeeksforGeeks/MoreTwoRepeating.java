import java.util.Arrays;


public class MoreTwoRepeating {
	public static void main(String[] args)
	{
		int[] arr= {1,1,1,2,2,2};
		repeat(arr);
	}
	public static void repeat(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])]>=0)
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}
}
