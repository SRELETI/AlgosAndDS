
public class InterLeavings {

	public void inter(String s, String s2, String result)
	{
		if((s==null || s.length()==0) && (s2==null || s2.length()==0))
			return;
		if(s==null || s.length()==0)
		{
			System.out.println(result+s2);
			return;
		}
		if(s2==null || s2.length()==0)
		{
			System.out.println(result+s);
			return;
		}
		inter(s.substring(1),s2,result+s.charAt(0));
		inter(s,s2.substring(1),result+s2.charAt(0));
	}
	
	public static void main(String args[])
	{
		InterLeavings i2 = new InterLeavings();
		String s ="AB";
		String s2 = "CD";
		
		int len1 = s.length();
		int len2 = s2.length();
	//	System.out.println(len1+len2);
		StringBuilder sss = new StringBuilder();
	//	System.out.println(sss.length());
		String result ="";
	//	System.out.println(result.length());
		
		i2.inter(s, s2, result);
	}
}
