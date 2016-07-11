import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.*;;
public class ZigZagConv {
	private static HashMap<Integer,String> h = new LinkedHashMap<Integer,String>();
	static
	{
		h.put(1000, "M");
		h.put(1, "I");
		h.put(4, "IV");
		h.put(5, "V");
		h.put(9, "IX");
		h.put(10, "X");
		h.put(40, "XL");
		h.put(50, "L");
		h.put(90, "XC");
		h.put(100, "C");
		h.put(400, "CD");
		h.put(500, "D");
		h.put(900, "CM");
		h.put(1000,"M");
	}
	
	
	    public boolean isMatch(String s, String p) {
	        if(s.equals(p))
	            return true;
	        Pattern patt = Pattern.compile(s);
	        Matcher match = patt.matcher(p);
	        if(match.find()==true)
	            return true;
	        else 
	            return false;
	    }
	    
	    
	    public String inttoRoman(int num)
	    {
	    	for(Integer i : h.keySet())
	    	{
	    		if(num>i)
	    		{
	    			return h.get(i) + inttoRoman(num-i);
	    		}
	    	}
	    	return "";
	    }
	private String convert(String s, int nrows) {
		if(s.length()==0 || nrows==1)
			return "";
		StringBuilder sb = new StringBuilder();
		
		int len = s.length();
		
		for(int i=0;i<len;i+=(nrows-1)*2)
		{
			sb.append(s.charAt(i));
		}
		
		for(int line=2;line<nrows-1;line++)
		{
			for(int i=line-1;i<len ;i+=(line-1)*2)
			{
				if(i<len)
					sb.append(s.charAt(i));
				i += (nrows-line)*2;
				if(i<len)
					sb.append(s.charAt(i));
			}
		}
		
		for(int i=nrows-1;i<len;i+=(nrows-1)*2)
		{
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
