
public class Subarr {

	public void find(int[] arr, int sum)
	{
		int cur_sum = arr[0];
		int start = 0;
		for(int i=1;i<arr.length;i++)
		{
			cur_sum = cur_sum + arr[i];
			while(cur_sum>sum && start<i)
			{
				cur_sum = cur_sum - arr[start];
				start++;
			}
			
			if(cur_sum==sum)
			{
				System.out.println("Sum found at from index "+start+" to "+i);
				return;
			}
			
			
		}
		System.out.println("Not found any subarray ");
	}
	
	public static void main(String args[])
	{
		int[] arr = {1, 4};
		Subarr s = new Subarr();
		s.find(arr, 0);
		
	}
}
