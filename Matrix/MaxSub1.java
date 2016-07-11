
public class MaxSub1 {
	public static void main(String args[])
	{
		int[][] arr = {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		matrix(arr);
	}
	public static int min(int a,int b, int c)
	{
		int min=a;
		if(b<min)
			min=b;
		if(c<min)
			min=c;
		return min;
	}
	public static void matrix(int[][] arr)
	{
		int[][] new_arr =  new int[arr.length][arr[0].length];
		for(int j=0;j<new_arr[0].length;j++)
			new_arr[0][j]=arr[0][j];
		for(int i=0;i<new_arr.length;i++)
			new_arr[i][0]=arr[i][0];
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[0].length;j++)
			{
				if(arr[i][j]==1)
				{
					new_arr[i][j]=min(new_arr[i][j-1],new_arr[i-1][j],new_arr[i-1][j-1])+1;
				}
				else
					new_arr[i][j]=0;
			}
		}
		int max_value=new_arr[0][0];
		int max_i=0;
		int max_j=0;
		for(int i=0;i<new_arr.length;i++)
		{
			for(int j=0;j<new_arr[0].length;j++)
			{
				if(new_arr[i][j]>max_value)
				{
					max_value=new_arr[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		for(int i=max_i;i>max_i-max_value;i--)
		{
			for(int j=max_j;j>max_j-max_value;j--)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
