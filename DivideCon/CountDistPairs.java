import java.util.Arrays;
import java.util.HashMap;


public class CountDistPairs {

	public void dist(int[] arr, int k)
	{
		Arrays.sort(arr);
		int i=0;
		int j=1;
		int total;
		int count=0;
		while(i<arr.length && j<arr.length)
		{
			total = arr[j]-arr[i];
			if(total == k)
			{
				System.out.println(arr[i]+" "+arr[j]);
				count++;
				j++;
			}
			else if(total<k)
			{
				j++;
			}
			else
				i++;
		}
		System.out.println(count);
	}
	public static void main(String args[])
	{
		int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		CountDistPairs c = new CountDistPairs();
	//	c.dist(arr, 3);
	//	c.hash_solution(arr, 3);
		c.move_zeros(arr);
	}
	
	public void move_zeros(int[] arr)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
				arr[count++]=arr[i];
		}
		while(count<arr.length)
		{
			arr[count++]=0;
		}
		System.out.println(Arrays.toString(arr));
	}
	public void hash_solution(int[] arr, int k)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(arr[i])==false)
				h.put(arr[i], 1);
		}
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(Math.abs(arr[i]+k))==true)
				count++;
		}
		System.out.println(count);
	}
	
}
