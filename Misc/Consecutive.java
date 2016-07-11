
public class Consecutive {
	public static void main(String args[])
	{
		int[] arr= {5,4,3,2,1,6};
		System.out.print(cons(arr));
	}
	public static boolean cons(int[] arr)
	{
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
				min=arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		if(max-min+1==arr.length)
		{
			boolean visited[]= new boolean[arr.length];
			for(int i=0;i<arr.length;i++)
			{
				if(visited[arr[i]-min]!=false)
					return false;
				else
					visited[arr[i]-min]=true;
			}
			return true;
		}
		else
			return false;
	}
}
