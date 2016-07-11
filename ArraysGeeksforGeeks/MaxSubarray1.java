import java.util.Arrays;


public class MaxSubarray1 {
	public static int min(int a,int b,int c)
	{
		int min=a;
		if(min>b)
			min=b;
		if(min>c)
			min=c;
		return min;
	}
	public static void max_array(int arr[][])
	{
		int row=arr.length;
		int col=arr[0].length;
		System.out.println(row+" "+col);
		int[][] sub = new int[row][col];
		for(int i=0;i<row;i++)
			sub[i][0]=arr[i][0];
		for(int i=0;i<col;i++)
			sub[0][i]=arr[0][i];
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				if(arr[i][j]==1)
					sub[i][j]=(min(sub[i][j-1],sub[i-1][j], sub[i-1][j-1]))+1;
				else
					sub[i][j]=0;				
			}
		}
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(sub));
		int max=sub[0][0];
		int max_i=0;
		int max_j=0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(sub[i][j]>max)
				{
					max=sub[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		System.out.println(max+" "+max_i+" "+max_j);
		for(int i=max_i;i>max_i-max;i--)
		{
			for(int j=max_j;j>max_j-max;j--)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		int[][] arr = {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		max_array(arr);
	}
}
