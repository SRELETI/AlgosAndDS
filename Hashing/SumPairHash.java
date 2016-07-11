import java.util.HashMap;


public class SumPairHash {

	public void checkPair(int[] arr, int x)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(x-arr[i])==true)
			{
				System.out.println("The pair is "+arr[i]+" "+(x-arr[i]));
				return;
			}
			else
			{
				h.put(arr[i], 1);
			}
		}
		System.out.println("no pair found");
	}
	
	public static void main(String args[])
	{
		SumPairHash s = new SumPairHash();
		
		int[] arr = {1,4,45,7,10,-8};
		s.checkPair(arr, 16);
	}
}
