import java.util.Arrays;


public class Seg01align {
	public static void main(String args[])
	{
		int[][] arr={{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		subarray(arr);
	}
	public static int min(int a,int b,int c)
	{
		int min=a;
		if(b<min)
			min=b;
		if(c<min)
			min=c;
		return min;
	}
	public static void subarray(int[][] arr)
	{
		int[][] subarr= new int[arr.length][arr[0].length];
		subarr[0][0]=arr[0][0];
		for(int i=1;i<arr.length;i++)
		{
			subarr[i][0]=arr[i][0];
		}
		for(int j=1;j<arr[0].length;j++)
		{
			subarr[0][j]=arr[0][j];
		}
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[i].length;j++)
			{
				if(arr[i][j]==1)
				{
					subarr[i][j]=min(subarr[i][j-1],subarr[i-1][j],subarr[i-1][j-1])+1;
				}
				else
					subarr[i][j]=0;
			}
		}
		System.out.println(Arrays.deepToString(subarr));
		int max_i=0;
		int max_j=0;
		int max=subarr[0][0];
		for(int i=0;i<subarr.length;i++)
		{
			for(int j=0;j<subarr[i].length;j++)
			{
				if(subarr[i][j]>max)
				{
					max=subarr[i][j];
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
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
