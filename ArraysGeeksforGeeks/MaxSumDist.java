
public class MaxSumDist {
	public static int max(int arr[])
	{
		int incl=arr[0];
		int excl=-70;
		System.out.println(excl);
		int excl_new;
		for(int i=0;i<arr.length;i++)
		{
			excl_new=Math.max(incl, excl);
			incl=excl+arr[i];
			excl=excl_new;
		}
		return Math.max(excl, incl);
	}
	public static void main(String args[])
	{
		int arr[] = {-5,-5,-10,-40,-50,-1};
		System.out.println(max(arr));
	}
}
