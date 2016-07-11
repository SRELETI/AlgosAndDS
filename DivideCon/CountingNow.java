import java.util.Arrays;


public class CountingNow {

	public void sortNow(int[] arr, int range)
	{
		int[] count = new int[range+1];
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
				min = arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			count[arr[i]-min]++;
		}
		for(int i=1;i<count.length;i++)
			count[i]= count[i]+count[i-1];
		int[] output = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			output[count[arr[i]-min]-1] = arr[i];
			--count[arr[i]-min];
		}
		for(int i=0;i<output.length;i++)
			arr[i]=output[i];
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[])
	{
		CountingNow c = new CountingNow();
		int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
		int range =5;
	//	c.sortNow(arr, range);
		System.out.println(c.maxSum(arr, 0, 7));
	}
	
	public int maxSum(int[] arr, int l, int h)
	{
		if(l==h)
		{
			return arr[l];
		}
		int middle = (l+h)/2;
		return Math.max(maxSum(arr,l,middle),Math.max(maxSum(arr,middle+1,h),maxCross(arr,l,h,middle)));
	}
	
	private int maxCross(int[] arr, int l, int h, int middle)
	{
		int sum=0;
		int left_sum = Integer.MIN_VALUE;
		for(int i=middle;i>=0;i--)
		{
			sum = sum+arr[i];
			if(sum>left_sum)
				left_sum = sum;
		}
		
		int right_sum = Integer.MIN_VALUE;
		sum=0;
		for(int i=middle+1;i<=h;i++)
		{
			sum = sum+arr[i];
			if(sum>right_sum)
				right_sum = sum;
		}
		return left_sum +right_sum;
	}
}
