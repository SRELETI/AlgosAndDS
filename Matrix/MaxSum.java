
public class MaxSum {
	public static void main(String args[])
	{
		int[] arr= {-2, -3, 4, -1, -2, 1, 5, -3};
		max(arr);
	}
	public static void max(int[] arr)
	{
		int v=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			int vmin=arr[i];
			for(int j=i+1;j<arr.length;j++)
			{
				vmin=vmin+arr[j];
				if(vmin>v)
					v=vmin;
			}
		}
		System.out.println(v);
	}
}
