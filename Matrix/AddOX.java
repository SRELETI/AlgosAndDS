import java.util.Arrays;


public class AddOX {
	public static void main(String args[])
	{
		int m=3;
		int n=4;
		print(m,n);
	}
	public static void print(int m, int n)
	{
		int row_min=0;
		int col_min=0;
		int row_max=m;
		int col_max=n;
		char[][] arr = new char[row_max][col_max];
		char counter='X';
		while(row_min<row_max && col_min < col_max)
		{
			for(int i=col_min;i<col_max;i++)
			{
				arr[row_min][i]=counter;
			}
			row_min++;
			for(int i=row_min;i<row_max;i++)
			{
				arr[i][col_max-1]=counter;
			}
			col_max--;
			if(col_min<col_max)
			{
				for(int i=col_max-1;i>=col_min;i--)
				{	
					arr[row_max-1][i]=counter;
				}
				row_max--;
			}
			if(row_min<row_max)
			{
				for(int i=row_max-1;i>=row_min;i--)
				{
						arr[i][col_min]=counter;
				}
				col_min++;
			}	
			if(counter=='X')
				counter='O';
			else
				counter='X';
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
