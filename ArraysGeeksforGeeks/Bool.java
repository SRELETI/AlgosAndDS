import java.util.Arrays;


public class Bool {
	public static void main(String args[])
	{
		int[][] arr = { {1, 0, 0, 1},
		        {0, 0, 1, 0},
		        {0, 0, 0, 0},
		    };
		boo(arr);
	}
	public static void boo(int[][] arr)
	{
		int[] row = new int[arr.length];
		int[] col = new int[arr[0].length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==1)
				{
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0;i<row.length;i++)
		{
			for(int j=0;j<col.length;j++)
			{
				if(row[i]==1 || col[j]==1)
					arr[i][j]=1;
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}
}
