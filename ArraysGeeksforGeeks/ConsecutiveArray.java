import java.util.Arrays;


public class ConsecutiveArray {
	public static void main(String args[])
	{
		int[] arr = {75,72,73,71,74};
		System.out.println(consecutive(arr));
		System.out.println(consecutive_mod(arr));
		System.out.println(consecutive_mod2(arr));
	}
	public static boolean consecutive(int[] arr)
	{
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-arr[i-1]!=1)
				return false;
		}
		return true;
	}
	public static int min(int arr[])
	{
		int min=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(min>arr[i])
				min=arr[i];
		}
		return min;
	}
	public static int max(int arr[])
	{
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
	public static boolean consecutive_mod(int[] arr)
	{
		int min=min(arr);
		int max=max(arr);
		if(max-min+1==arr.length)
		{
			boolean[] visited = new boolean[arr.length];
			for(int i=0;i<arr.length;i++)
			{
				if(visited[arr[i]-min]==true)
					return false;
				visited[arr[i]-min]=true;
			}
			return true;
		}
		return false;
	}
	public static boolean consecutive_mod2(int[] arr)
	{
		int min=min(arr);
		int max=max(arr);
		if(max-min+1==arr.length)
		{
			for(int i=0;i<arr.length;i++)
			{
				int j=0;
				if(arr[i]<0)
					j=-(arr[i]-min);
				else
					j=arr[i]-min;
				if(arr[j]>0)
					arr[j]=-arr[j];
				else
					return false;
			}
			return true;
		}
		return false;
	}
}
