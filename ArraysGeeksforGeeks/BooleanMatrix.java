import java.util.Arrays;


public class BooleanMatrix {
	public static void main(String args[])
	{
		int[][] arr={{1,0,0,1},{0,0,1,0},{0,0,0,0}};
		bool(arr);
	}
	public static void bool(int[][] arr)
	{
		boolean[] row = new boolean[arr.length];
		boolean[] col = new boolean[arr[0].length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==1)
				{
					row[i]=true;
					col[j]=true;
				}
			}
		}
		print(arr);
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(row[i]==true || col[j]==true)
					arr[i][j]=1;
			}
		}
		System.out.println();
		print(arr);
	}
	public static void print(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
