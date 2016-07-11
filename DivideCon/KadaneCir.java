
public class KadaneCir {

	public void kadane2(int[] arr)
	{
		int max_sum = kadane(arr);
		int max_wrap=0;
		for(int i=0;i<arr.length;i++)
		{
			max_wrap = max_wrap+arr[i];
			arr[i]=-arr[i];
		}
		max_wrap += kadane(arr);
		System.out.println(max_wrap>max_sum ? max_wrap : max_sum);
	}
	
	private int kadane(int[] arr)
	{
		int cur_sum = arr[0];
		int max_sum = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			cur_sum = Math.max(cur_sum+arr[i], arr[i]);
			max_sum = Math.max(max_sum, cur_sum);
		}
		return max_sum;
	}
	
	public static void main(String args[])
	{
		int[] arr = {-1, 40, -14, 7, 6, 5, -4, -1};
		KadaneCir k = new KadaneCir();
		k.kadane2(arr);
	}
}
