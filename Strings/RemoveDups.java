import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;


public class RemoveDups {

	public void remove(String input)
	{
		LinkedHashSet<Character> l = new LinkedHashSet<Character>();
		for(int i=0;i<input.length();i++)
		{
			l.add(input.charAt(i));
		}
		StringBuilder s = new StringBuilder();
		for(Character c : l)
		{
			s.append(c);
		}
		System.out.println(s.toString());
	}
	
	public static void main(String args[])
	{
		String str = "aabbccdefatafaz";
		RemoveDups r = new RemoveDups();
		r.remove(str);
		r.rem(str);
	}
	
	public void rem(String input)
	{
		Map<Character,Integer> h = new TreeMap<Character,Integer>();
		for(int i=0;i<input.length();i++)
		{
			if(h.containsKey(input.charAt(i))==false)
				h.put(input.charAt(i), 1);
		}
		
		StringBuilder b = new StringBuilder();
		for(Character k:h.keySet())
			b.append(k);
		System.out.println(b.toString());
	}
}
