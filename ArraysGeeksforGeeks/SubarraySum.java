
public class SubarraySum {
	public static void main(String args[])
	{
		int[] arr = {1,4,20,3,10,5};
		sum(arr,33);
	}
	public static void sum(int[] arr, int result)
	{
		int j;
		for(int i=0;i<arr.length;i++)
		{
			int sum=arr[i];
			for(j=i+1;j<arr.length;j++)
			{
				if(sum==result)
				{
					System.out.println("The max cont array is "+i+" to "+j);
					return;
				}
				sum=sum+arr[j];
			}
		}
	}
	public static void google(int[] arr, int sum)
	{
		int curr_sum=arr[0];
		int start=0;
		for(int i=1;i<arr.length;i++)
		{
			while(curr_sum>sum && start<i-1)
			{
				curr_sum=curr_sum-arr[start];
				start++;
			}
			if(curr_sum==sum)
			{
				System.out.println("The sub array is "+start+" to "+(i-1));
				return;
			}
			curr_sum=curr_sum+arr[i];
		}
		System.out.println("No such array ");
	}
}
