
public class MinDistTwoNum {
	public static void main(String args[])
	{
		int[] arr= {2, 5, 3, 5, 4, 4, 2, 3};
		dist(arr,3,2);
		dist_im(arr,3,2);
	}
	public static void dist(int[] arr, int x, int y)
	{
		int min_dist=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(((arr[i]==x && arr[j]==y)||(arr[i]==y && arr[j]==x)) && Math.abs(i-j)<min_dist)
					min_dist=Math.abs(i-j);
			}
		}
		System.out.println(min_dist);
	}
	public static void dist_im(int[] arr, int x, int y)
	{
		int min_dist=Integer.MAX_VALUE;
		int prev=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==x || arr[i]==y)
			{
				prev=i;
				break;
			}
		}
		//System.out.println(prev);
		for(int i=prev+1;i<arr.length;i++)
		{
			if(arr[i]==x || arr[i]==y)
			{
				if(arr[i]!=arr[prev] && (i-prev)<min_dist)
				{
					min_dist=Math.abs(i-prev);
				}
				prev=i;
			}
		}
		System.out.println(min_dist);
	}
}
