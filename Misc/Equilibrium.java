
public class Equilibrium {
	public static void main(String args[])
	{
		int[] arr={-7,1,5,2,-4,3,0};
		eq(arr);
		eq2(arr);
	}
	public static void eq(int[] arr)
	{
		
		for(int i=0;i<arr.length;i++)
		{
			int left_sum=0;
			int right_sum =0;
			for(int j=0;j<i;j++)
			{
				left_sum=left_sum+arr[j];
			}
			for(int j=i+1;j<arr.length;j++)
			{
				right_sum=right_sum+arr[j];
			}
			if(left_sum==right_sum)
				System.out.println("The eq1 index is"+i);
		}
	}
	public static void eq2(int[] arr)
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum=sum+arr[i];
		int left_sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum=sum-arr[i];
			if(sum==left_sum)
				System.out.println("The eq index is "+i);
			left_sum=left_sum+arr[i];
		}
	}
}
