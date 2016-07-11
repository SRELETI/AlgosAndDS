
public class PatternSearchNaive {

	public void pattern(String text, String pattern)
	{
		int i=0;
		
		int t_len = text.length();
		int p_len = pattern.length();
		
		while(i<=t_len-p_len)
		{
			int j;
			
			for(j=0;j<p_len;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			
			if(j==p_len)
			{
				System.out.println("THe string is starting at "+i);
				i=i+1;
			}
			else if(j==0)
				i=i+1;
			else
				i=i+j;
		}
		
	}
	
	public static void main(String args[])
	{
		PatternSearchNaive p = new PatternSearchNaive();
		
		String text = "ABCEABCDABCEABCD";
		String pattern = "ABCD";
		p.pattern(text, pattern);
	}
	
}
