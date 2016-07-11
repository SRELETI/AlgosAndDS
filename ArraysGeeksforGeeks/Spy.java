
public class Spy {
	public static void main(String args[])
	{
		int[][] arr = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		spiral(arr);
	}
	public static void spiral(int[][] arr)
	{
		int row_min=0;
		int col_min=0;
		int row_max=arr.length;
		int col_max=arr[0].length;
		while(row_min<row_max && col_min<col_max)
		{
			for(int i=col_min;i<col_max;i++)
			{
				System.out.print(arr[row_min][i]+" ");
			}
			row_min++;
			for(int i=row_min;i<row_max;i++)
			{
				System.out.print(arr[i][col_max-1]+" ");
			}
			col_max--;
			if(row_min<row_max)
			{
				for(int i=col_max-1;i>=col_min;i--)
				{
					System.out.print(arr[row_max-1][i]+" ");
				}
				row_max--;
			}
			if(col_min<col_max)
			{
				for(int i=row_max-1;i>=row_min;i--)
				{
					System.out.print(arr[i][col_min]+" ");
				}
				col_min++;
			}
		}
	}
}
