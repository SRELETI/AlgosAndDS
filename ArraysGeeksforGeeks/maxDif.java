
public class maxDif {

	public void max(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]-arr[i]>max)
					max =arr[j]-arr[i];
			}
		}
		System.out.println(max);
	}
	
	public static void main(String args[])
	{
		maxDif m = new maxDif();
		int[] arr = {2,3,10,6,4,8,1};
		m.max(arr);
		m.max2(arr);
	}
	
	public void max2(int[] arr)
	{
		int min = arr[0];
		int max_sum = arr[1]-arr[0];
		for(int i=1;i<arr.length;i++)
		{
			int diff = arr[i]-min;
			if(diff>max_sum)
				max_sum = diff;
			if(arr[i]<min)
				min = arr[i];
		}
		System.out.println(max_sum);
	}
}
