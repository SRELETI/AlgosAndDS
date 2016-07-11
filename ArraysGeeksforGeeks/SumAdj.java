import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class SumAdj {

	public void sum(int[] arr)
	{
		int incl=0;
		int excl=0;
		int excl_new;
		for(int i=0;i<arr.length;i++)
		{
			excl_new = Math.max(incl, excl);
			incl = excl+arr[i];
			excl = excl_new;
		}
		System.out.println(excl>incl ? excl : incl);
	}
	
	public static void main(String args[])
	{
		SumAdj s = new SumAdj();
		int[] arr = {2,5,2,8,5,6,8,8};
	//	s.sum(arr);
	//	s.leader(arr);
		s.freq(arr);
	}
	
	public void leader(int[] arr)
	{
		int max =Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--)
		{
			if(arr[i]>max)
			{
				System.out.println(arr[i]);
				max = arr[i];
			}
		}
	}
	
	public void freq(int[] arr)
	{
		Map<Integer,Integer> h = new TreeMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(arr[i]))
				h.put(arr[i], h.get(arr[i])+1);
			else
				h.put(arr[i], 1);
		}
		
		for(Map.Entry<Integer,Integer> i : h.entrySet())
		{
			
			for(int j=0;j<i.getValue();j++)
				System.out.print(i.getKey());
		}
	}
}
