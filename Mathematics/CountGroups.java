import java.util.HashMap;


public class CountGroups {

	public void count(int[] arr)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		int key;
		for(int i=0;i<arr.length;i++)
		{
			key = arr[i]%3;
			if(h.containsKey(key)==true)
				h.put(key, h.get(key)+1);
			else
				h.put(key, 1);
		}
		
		int c=h.get(0);
		int c1 = h.get(1);
		int c2 = h.get(2);
		int count = 0;
		count = (c)*(c-1)/2;
		count = count + c1*c2;
		
		count = count + (c*(c-1)*(c-2))/6;
		count = count + (c1*(c1-1)*(c1-2))/6;
		count = count + (c2*(c2-1)*(c2-2))/6;
		
		count = count + c*c1*c2;
		System.out.println("Total number of groups "+count);
	}
	
	public static void main(String args[])
	{
		int[] arr = {2, 1, 3, 4};
		CountGroups c = new CountGroups();
		c.count(arr);
	}
}
