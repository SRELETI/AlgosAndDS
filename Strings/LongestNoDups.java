import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class LongestNoDups {
	private int max_len = Integer.MIN_VALUE;
	public void noDups(String text)
	{
		callAc(text,0,text.length());
		System.out.println(max_len);
	}
	
	public void callAc(String s, int start, int end)
	{
		if(start == s.length() && end == s.length())
			return;
		else if(end == s.length()+1)
			callAc(s,start+1,start+1);
		else
		{
			callSubString(s,start,end);
			callAc(s,start,end+1);
		}
	}
	
	public void callSubString(String s, int start, int end)
	{
		HashMap<Character,Integer> h = new LinkedHashMap<Character,Integer>();
		for(int i=start;i<end;i++)
		{
			if(h.containsKey(s.charAt(i)))
				h.put(s.charAt(i), h.get(s.charAt(i))+1);
			else
				h.put(s.charAt(i), 1);
		}
		
		for(Map.Entry<Character,Integer> m : h.entrySet())
		{
			if(m.getValue()>1)
				return;
		}
		if(h.size()>max_len)
			max_len = h.size();
		
	}
	public static void main(String args[])
	{
		String s ="ABDEFGABEF";
		
		LongestNoDups l = new LongestNoDups();
		
		l.noDups(s);
	}
}
