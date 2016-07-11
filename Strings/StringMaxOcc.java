import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringMaxOcc {

	public void maxCount(String s)
	{
		char[] c = s.toCharArray();
		
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		
		for(int i=0;i<c.length;i++)
		{
			if(h.containsKey(c[i])==false)
				h.put(c[i], 1);
			else
			{
				int val = h.get(c[i]);
				h.put(c[i], val+1);
			}
		}
		int max= Integer.MIN_VALUE;
		char ch=' ';
		System.out.println(h.entrySet());
		for(Map.Entry<Character, Integer> entry : h.entrySet())
		{
			if(entry.getValue()>max)
			{
				max = entry.getValue();
				ch = entry.getKey();
			}
		}
		System.out.println(ch);
	}
	
	public static void main(String args[])
	{
		StringMaxOcc s = new StringMaxOcc();
		String ss = "test String";
		s.maxCount(ss);
	}
}
