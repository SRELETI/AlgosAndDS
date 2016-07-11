import java.util.HashMap;
import java.util.LinkedHashMap;


public class TwoStringsCommon {

	public void removeCommon(String str1, String str2)
	{
		HashMap<Character,Integer> h = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<str2.length();i++)
		{
			if(h.containsKey(str2.charAt(i))==false)
				h.put(str2.charAt(i), 1);
		}
		StringBuilder str = new StringBuilder(str1);
		int count=0;
		while(count<str.length())
		{
			if(h.containsKey(str.charAt(count))==true)
				str.deleteCharAt(count);
			else 
				count++;
		}
		System.out.println(str.toString());
	}
	
	public static void main(String args[])
	{
		String str2= "mask";
		String str1 = "geeskforgeeks";
		TwoStringsCommon t = new TwoStringsCommon();
		t.removeCommon(str1, str2);
	}
	
}
