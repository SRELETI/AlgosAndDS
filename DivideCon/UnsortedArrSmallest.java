import java.util.Arrays;
import java.util.HashMap;


public class UnsortedArrSmallest {

	public void naive(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		int j;
		for(int i=1;i<Integer.MAX_VALUE;i++)
		{
			for(j=0;j<arr.length;j++)
			{
				if(arr[j]==i)
					break;
			}
			if(j==arr.length)
			{
				System.out.println("THe number missing "+i);
				return;
			}
		}
	}
	
	public void sorting(int[] arr)
	{
		Arrays.sort(arr);
		int i;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
				break;
		}
		for(int j=1;j<Integer.MAX_VALUE;j++)
		{
			if(j==arr[i])
			{
				i++;
			}
			else
			{
				System.out.println(j);
				return;
			}
		}
	}
	
	public void hashing(int[] arr)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			h.put(arr[i], 1);
		}
		
		for(int i=1;i<Integer.MAX_VALUE;i++)
		{
			if(h.containsKey(i)==false)
			{
				System.out.println(i);
				return;
			}
		}
	}
	
	public static void main(String args[])
	{
		UnsortedArrSmallest u = new UnsortedArrSmallest();
		int[] arr = {1, 1, 0, -1, -2};
		u.naive(arr);
		u.sorting(arr);
		u.hashing(arr);
	}
}
