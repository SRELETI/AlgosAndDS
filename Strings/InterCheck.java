
public class InterCheck {

	public boolean check(String s1, String s2, String result)
	{
		int x=0,y=0;
		for(int i=0;i<result.length();i++)
		{
			if(x<s1.length() && result.charAt(i)==s1.charAt(x))
				x++;
			else if(y<s2.length() && result.charAt(i)==s2.charAt(y))
				y++;
			else 
				return false;
		}
		if(x<s1.length() || y<s2.length())
			return false;
		return true;
	}
	
	public static void main(String args[])
	{
		InterCheck i = new InterCheck();
		String s1 = "AAB";
		String s2 = "AAC";
		String result = "AACAAB";
		System.out.println(i.check(s1, s2, result));
	}
}
