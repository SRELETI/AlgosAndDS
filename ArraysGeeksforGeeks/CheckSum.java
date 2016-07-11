import java.util.Arrays;
import java.util.HashMap;


public class CheckSum {

	public boolean check(int[] arr, int sum)
	{
		Arrays.sort(arr);
		int start=0;
		int end = arr.length-1;
		while(start<end)
		{
			if(arr[start]+arr[end]==sum)
				return true;
			else if(arr[start]+arr[end]<sum)
				start++;
			else
				end--;
		}
		return false;
	}
	
	public boolean check2(int[] arr, int sum)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(sum-arr[i]))
				return true;
			else
				h.put(arr[i], arr[i]);
		}
		return false;
	}
	
	public static void main(String args[])
	{
		int[] arr = {1,4,45,6,10,8};
		int n=20;
		CheckSum s = new CheckSum();
		System.out.println(s.check(arr, n));
		System.out.println(s.check2(arr, n));
	}
}
