
public class LongestPalind {

	private void longest(String s) {
		if(s.length()==0)
			return;
		int n = s.length();
		boolean[][] res = new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			res[i][i] = true;
		}
		int maxLength = 1;
		int start = 0;
		for(int i=0;i<n-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{
				res[i][i+1] = true;
				maxLength= 2;
				start=i;
			}
		}
		
		for(int i=3;i<=n;++i)
		{
			for(int k=0;k<n-i+1;++k)
			{
				int j = k+i-1;
				if(res[k+1][j-1]==true && s.charAt(k)==s.charAt(j))
				{
					res[k][j] = true;
					if(i>maxLength)
					{
						maxLength = i;
						start=k;
					}
				}
			}
		}
		
		System.out.println("The maxlength palindrome is "+maxLength+" and the string is ");
		for(int i=start;i<=start+maxLength-1;i++)
			System.out.print(s.charAt(i)+" ");
		
	}
	
	public static void main(String args[]) {
		LongestPalind l  = new LongestPalind();
	//	l.longest("geeksskeeg");
		l.longestPalin("geeksskeeg");
	}
	
	public void longestPalin(String s) {
		if(s.length()==0)
			return;
		int maxLength = 1;
		int start = 0;
		for(int i=1;i<s.length();i++)
		{
			int low;
			int high;
			low = i-1;
			high = i;
		//	System.out.println(low+ " "+high);
		//	System.out.println(s.charAt(i));
			while((low>=0) && (high <s.length()) && (s.charAt(low)==s.charAt(high)))
			{
				if(high-low+1>maxLength)
				{
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
			
			low = i-1;
			high = i+1;
			while(low>= 0 && high <s.length() && s.charAt(low)==s.charAt(high))
			{
				if(high-low+1>maxLength)
				{
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
		}
		System.out.println(maxLength);
		System.out.println(start+" "+ (start+maxLength-1));
	}
}
