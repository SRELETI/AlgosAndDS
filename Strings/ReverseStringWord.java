
public class ReverseStringWord {

	public void reverseProg(String s)
	{
		StringBuilder d = new StringBuilder(s);
		reverseString(d);
	}
	public void reverseString(StringBuilder s)
	{
		int start= 0;
		int word_begin = 0;
		while(start<s.length())
		{
			if(start == s.length()-1)
				reverse(s,word_begin,s.length()-1);
			
			else if(s.charAt(start)==' ')
			{
				reverse(s,word_begin,start-1);
				word_begin = start+1;
			}
			start++;
		//	System.out.println(start);
		}
		reverse(s,0,s.length()-1);
		System.out.println(s.toString());
	}
	
	public void reverse(StringBuilder s, int start, int end)
	{
		while(start<end)
		{
			char val = s.charAt(start);
			s.setCharAt(start, s.charAt(end));
			s.setCharAt(end, val);
			start++;
			end--;
		}
	}
	
	public static void main(String args[])
	{
		ReverseStringWord r = new ReverseStringWord();
		
		String s = " I like this program very much";
		r.reverseProg(s);
	}
}
