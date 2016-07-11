
public class KMPPattern {

	public void pattern(String text, String pattern)
	{
		int pattern_length = pattern.length();
		int text_length = text.length();
		
		int i=0;
		int j=0;
		
		int[] lps= new int[pattern_length];
		
		constructArray(pattern,lps);
		
		while(i<text_length)
		{
			if(text.charAt(i) == pattern.charAt(j))
			{
				i++;
				j++;
				
				if(j==pattern_length)
				{
					System.out.println("The string found at "+(i-j));
					j=lps[j-1];
				}
			}
			else 
			{
				if(j!=0)
					j = lps[j-1];
				else
					i= i+1;
			}
			
		}
	}
	
	public void constructArray(String pattern, int[] lps)
	{
		int len = 0;
		int i=1;
		lps[0] = 0;
		
		while(i<lps.length)
		{
			if(pattern.charAt(i)==pattern.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else if(len!=0)
				len = lps[len-1];
			else
			{
				lps[i]=0;
				i++;
			}
		}
	}
	
	public static void main(String args[])
	{
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABAB";
		
		KMPPattern k = new KMPPattern();
		
		k.pattern(text, pattern);
	}
}
