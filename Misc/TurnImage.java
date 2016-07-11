import java.util.Arrays;


public class TurnImage {
	public static void main(String args[])
	{
		int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		rotate(arr);
	}
	public static void rotate(int[][] arr)
	{
		int[][] dest = new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				dest[j][arr.length-i-1]=arr[i][j];
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Dest Array ");
		for(int i=0;i<dest.length;i++)
		{
			for(int j=0;j<dest[0].length;j++)
			{
				System.out.print(dest[i][j]+" ");
			}
			System.out.println();
		}
	}
}
