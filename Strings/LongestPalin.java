import java.util.ArrayList;
import java.util.Iterator;


public class LongestPalin {

	public void longest(String text)
	{
		ArrayList<String> s = new ArrayList<String>();
		findSubString(text,s,0,1);
		Iterator<String> ss = s.iterator();
		int max_leng = 0;
		while(ss.hasNext())
		{
			if(checkPalindrome(ss.toString()))
			{
				System.out.println(ss.toString());
				if(ss.toString().length()>max_leng)
					max_leng = ss.toString().length();
			}
			ss.next();
		}
		System.out.println(max_leng);
	}
	
	private boolean checkPalindrome(String s)
	{
		int start = 0;
		int end = s.length()-1;
		while(start<end)
		{
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	private void findSubString(String text, ArrayList<String> s, int start, int end)
	{
		if(start == text.length() && end == text.length())
		{
			return;
		}
		else if(end == text.length()+1)
			findSubString(text,s,start+1,start+1);
		else
		{
			s.add(text.substring(start,end));
			findSubString(text,s,start,end+1);
		}
	}
	
	public static void main(String args[])
	{
		LongestPalin l = new LongestPalin();
		String s = "forgeeksskeegfor";
		l.longest(s);
	}
}
