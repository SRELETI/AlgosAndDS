
public class SubArray {

	public void subArray(int[] arr, int sum)
	{
		int total;
		for(int i=0;i<arr.length-1;i++)
		{
			total = 0;
			for(int j=i;j<arr.length && total<=sum;j++)
			{
				total = total+arr[j];
				if(total==sum)
				{
					System.out.println("the indexes are "+i+" "+j);
					return;
				}
			}
		}
	
	}
	
	public void opt_subArray(int[] arr, int sum)
	{
		int start=0;
		int end=0;
		int total = 0;
		for(int i=0;i<arr.length;i++)
		{
			total = total+arr[i];
			end = i;
			while(total>sum)
			{
				total = total-arr[start];
				start++;
			}
			if(total==sum && start<=end)
			{
				System.out.println("The indexes are "+start+" "+end);
				return;
			}
		}
	}
	public static void main(String args[])
	{
		int[] arr = {1, 4, 20, 3, 10, 5};
		SubArray s = new SubArray();
		s.subArray(arr, 33);
		s.opt_subArray(arr, 33);
	}
			
}
