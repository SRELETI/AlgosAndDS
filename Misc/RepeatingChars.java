import java.util.HashMap;


public class RepeatingChars {

	private int repeat(String s ) {
		if(s.length()==0)
			return 0;
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		h.put(s.charAt(0), 1);
		int i=1;
		for(i=1;i<s.length();i++)
		{
			if(h.containsKey(s.charAt(i))==true)
				return i;
			else 
				h.put(s.charAt(i), 1);
		}
		
		return i;
	}
}
