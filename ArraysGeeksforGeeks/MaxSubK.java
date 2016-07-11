
public class MaxSubK {
	public static void main(String args[])
	{
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		max(arr,4);
	}
	public static void max(int[] arr, int k)
	{
		for(int i=0;i<=arr.length-k;i++)
		{
			int max=0;
			for(int j=i+1;j<i+k;j++)
			{
				if(arr[j]>=arr[i])
					max=Math.max(arr[j],max);
				else if(arr[i]>arr[j])
					max=Math.max(arr[i], max);
			}
			System.out.println(max+" ");
		}
	}
}
