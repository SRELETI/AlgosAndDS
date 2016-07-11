import java.util.HashMap;


public class RemDupStr {

	public void remove(String ss)
	{
		StringBuilder s = new StringBuilder();
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		for(int i=0;i<ss.length();i++)
		{
			if(h.containsKey(ss.charAt(i))==false)
			{
				s.append(ss.charAt(i));
				h.put(ss.charAt(i), 1);
			}
		}
		System.out.println(s.toString());
	}
	
	public static void main(String args[])
	{
		RemDupStr r = new RemDupStr();
		String s ="geeksforgeeks";
		r.remove(s);
	}
}
