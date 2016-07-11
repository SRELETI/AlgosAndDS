
public class DistinctBoolean {
	public static void main(String args[])
	{
		int[][] arr = {{0, 1, 0, 0, 1},
		        {1, 0, 1, 1, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 1, 0, 0}
		    };
		matrix(arr);
	}
	public static void matrix(int[][] arr)
	{
		int row_length=arr.length;
		int col_length=arr[0].length;
		for(int i=0;i<col_length;i++)
		{
			System.out.print(arr[0][i]+" ");
		}
		System.out.println();
		int count=0;
		for(int i=1;i<row_length;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				count=0;
				for(int k=0;k<col_length;k++)
				{
					if(arr[j][k]==arr[i][k])
						count++;
				}
				if(count==col_length)
					break;
			}
			if(count!=col_length)
			{
				for(int x=0;x<col_length;x++)
				{
					System.out.print(arr[i][x]+" ");
				}
				System.out.println();
			}
		}
	}
}
