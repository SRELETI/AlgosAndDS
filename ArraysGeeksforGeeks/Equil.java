
public class Equil {

	public void find(int[] arr)
	{
		int sum = arr[0];
		for(int i=1;i<arr.length;i++)
			sum = sum + arr[i];
		int left_sum = 0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum-arr[i];
			if(sum==left_sum)
				System.out.println(i);
			left_sum = left_sum+arr[i];
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {0,-10,0,0};
		Equil d  = new Equil();
	//	d.find(arr);
		d.testing(arr);
	}
	
	public void testing(int[] arr)
	{
		int max_prod = 1;
		int min_prod = 1;
		int result = Integer.MIN_VALUE;
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				max_prod = max_prod*arr[i];
				min_prod = Math.min(min_prod*arr[i], 1);
			}
			else if(arr[i]==0)
			{
				count++;
				max_prod = 1;
				min_prod = 1;
			}
			else
			{
				int temp_min = max_prod*arr[i];
				max_prod = Math.max(min_prod*arr[i], 1);
				min_prod = temp_min;
			}
			if(max_prod>result)
				result = max_prod;
		}
		if(count == arr.length-1)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]!=0)
				{
					System.out.println(arr[i]);
					return;
				}
			}
		}
		if(count == arr.length)
		{
			System.out.println(0);
			return;
		}
		System.out.println(result);
	}
	
	
}
