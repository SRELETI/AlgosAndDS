import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class AnagramString {
	public boolean anagram(String s, String s2)
	{
		char[] ss = new char[s.length()];
		char[] ss2 = new char[s2.length()];
		
		Arrays.sort(ss);
		Arrays.sort(ss2);
		
		if(ss.length != ss2.length)
			return false;
		int i;
		for(i=0;i<ss.length;i++)
		{
			if(ss[i]!=ss2[i])
				break;
		}
		if(i!=ss.length)
			return false;
		return true;
	}
	
	public boolean anagramHash(String s, String s2)
	{
		if(s.length()!=s2.length())
			return false;
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			if(h.containsKey(s.charAt(i))==false)
				h.put(s.charAt(i),1);
			else
			{
				h.put(s.charAt(i),h.get(s.charAt(i))+1);
			}
		}
		
		for(int i=0;i<s2.length();i++)
		{
			if(h.containsKey(s2.charAt(i))==false || h.get(s2.charAt(i))==0)
				return false;
			else
			{
				int temp = h.get(s2.charAt(i));
				h.put(s2.charAt(i), temp-1);
			}
		}
		return true;
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter first string: ");
		String s1 = br.readLine();
		System.out.print("Enter second String: ");
		String s2 = br.readLine();
		
		AnagramString a = new AnagramString();
		System.out.println();
	//	System.out.println(a.anagram(s1, s2));
		System.out.println(a.anagramHash(s1, s2));
	}
}
