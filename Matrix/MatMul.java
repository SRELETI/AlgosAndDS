
public class MatMul {
	public static void main(String args[])
	{
		
	}
	public static void mul(int[][] arr,int[][] arr2)
	{
		int c[][] = new int[arr.length][];
		for(int i=0;i<arr[0].length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				c[i][j]=0;
				for(int k=0;k<arr.length;k++)
				{
					c[i][j]=c[i][j]+arr[i][k]*arr2[k][j];
				}
			}
		}
	}
}
