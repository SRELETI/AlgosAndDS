
public class Max_subarray_dcc {
	public int max(int a,int b)
	{
		return (a>b)?a:b;
	}
	public int max(int a,int b,int c)
	{
		return max(max(a,b),c);
	}
	public int maxcrossingsum(int[] arr,int l,int m,int r)
	{
		int sum=0;
		int left_sum=Integer.MIN_VALUE;
		for(int i=m;i>=0;i--)
		{
			sum=sum+arr[i];
			if(left_sum<sum)
			{
				left_sum=sum;
			}
		}
		sum=0;
		int right_sum=Integer.MIN_VALUE;
		for(int j=m+1;j<=r;j++)
		{
			sum=sum+arr[j];
			if(right_sum<sum)
			{
				right_sum=sum;
			}
		}
		return left_sum+right_sum;
	}
	public int max_subarray(int[] arr,int left,int right)
	{
		if(left==right)
			return arr[left];
		int middle=(left+right)/2;
		return max(max_subarray(arr,left,middle),
				max_subarray(arr,middle+1,right),
				maxcrossingsum(arr,left,middle,right));
	}
	public static void main(String args[])
	{
		int arr[]={};
		int n=arr.length-1;
		if(n<0)
		{
			n=0;
		}
		Max_subarray_dcc msd=new Max_subarray_dcc();
		System.out.print(msd.max_subarray(arr, 0, n));
	}
	
}
