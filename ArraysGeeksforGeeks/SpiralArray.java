
public class SpiralArray {
	public static void main(String args[])
	{
		int[][] arr= {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
		spiral(arr);
	}
	public static void spiral(int[][] arr)
	{
		int n=arr.length;   // max row index
		int m=arr[0].length; // max col index
		int i; 
		int r=0;  // min row index
		int l=0;  // min col index
		while(r<n && l<m)
		{
			for(i=l;i<m;i++)
				System.out.print(arr[r][i]+" ");
			r++;
			for(i=r;i<n;i++)
				System.out.print(arr[i][m-1]+" ");
			m--;
			if(r<n)
			{
				for(i=m-1;i>=l;i--)
					System.out.print(arr[n-1][i]+" ");
				n--;
			}
			if(l<m)
			{
				for(i=n-1;i>=r;i--)
					System.out.print(arr[i][l]+" ");
				l++;
			}
		}
	}
}
