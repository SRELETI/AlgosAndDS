import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class MinWindow {

	public void subString(String s,String str)
	{
		int min_length = Integer.MAX_VALUE;
		String min_str = "";
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				if(s.substring(i, j).contains(str))
				{
					if(s.substring(i, j).length()<min_length)
					{
						min_length = s.substring(i, j).length();
						min_str = s.substring(i, j);
					}
				}
			}
			
		}
		
		if(min_str!=null)
			System.out.println("The min window is "+min_str+ " and length is  "+min_length);
	}
	
	public void opt_Min(String s, String target)
	{
		int min = Integer.MAX_VALUE;
		HashSet<Character> hh = new HashSet<Character>();
		for(int i=0;i<target.length();i++)
			hh.add(target.charAt(i));
		TreeMap<Character, Integer> where = new TreeMap<Character,Integer>();
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			if(hh.contains(s.charAt(i)))
			{
				if(where.containsKey(s.charAt(i)))
				{
					t.remove(where.get(s.charAt(i)));
				}
				where.put(s.charAt(i), i);
				t.add(i);
				
				if(t.size()==hh.size())
				{
					int first = t.first();
					int last = t.last();
					if(last-first+1<min)
					{
						System.out.println(first +" "+ last);
						min = last-first+1;
					}
				}
			}
		}
		System.out.println(min);
	}
	
	public static void main(String args[])
	{
		String ss = "ADOBECODEBANC";
		String target = "ABC";
		MinWindow m = new MinWindow();
	//	m.subString(ss, target);
	//	m.opt_Min(ss, target);
		
		m.subString(target, 0, 1);
	}
	
	
	public void subString(String s, int start, int end)
	{
		if(start==s.length() && end == s.length())
			return;
		else if(end == s.length()+1)
			subString(s,start+1,start+1);
		else
		{
			System.out.print(s.substring(start, end)+" ");
			subString(s,start,end+1);
		}
	}
}
