
public class PatternSearch {

	public void pattern(String text, String pattern)
	{
		int text_len = text.length();
		int pattern_len = pattern.length();
		for(int i=0;i<=text_len-pattern_len;i++)
		{
			int j;
			for(j=0;j<pattern_len;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==pattern_len)
				System.out.println("The pattern found at "+i);
		}
	}
	
	public static void main(String args[])
	{
		PatternSearch p = new PatternSearch();
		
		String text = "AABAACAADAAAAA";
		String pattern = "AAA";
		
		p.pattern(text, pattern);
		
	}
}
