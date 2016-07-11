import java.util.HashMap;


public class RepeatChars {

	public int repeat(String s) {
		if(s.length()<=1)
			return s.length();
		int maxLength =0;
		int start = 0;
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			start = Math.max(start, h.containsKey(s.charAt(i))==true ? h.get(s.charAt(i))+1:0);
			maxLength = Math.max(maxLength,i-start+1);
			h.put(s.charAt(i), i);
		}
		return maxLength;
	}
	
	public static void main(String args[]) {
		RepeatChars r = new RepeatChars();
		System.out.println(r.repeat("Sudeep"));
		r.longestPalind("forgeeksskeegrf");
		r.longestPal("forgeeksskeegrf");
	}
	
	public int longestPalind(String s) {
		if(s.length()<=1)
			return s.length();
		int n = s.length();
		boolean[][] res = new boolean[n][n];
		for(int i=0;i<n;i++)
			res[i][i]=true;
		int maxLength= 1;
		int start = 0;
		for(int i=0;i<n-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{
				res[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}
		int j;
		for(int k=3;k<=n;k++)
		{
			for(int i=0;i<n-k+1;i++)
			{
				j= i+k-1;
				if(res[i+1][j-1]==true && s.charAt(i)==s.charAt(j))
				{
					res[i][j] = true;
					if(k>maxLength)
					{
						maxLength = k;
						start =i;
					}
				}
			}
		}
		
		System.out.println(maxLength);
		System.out.println(s.substring(start,start+maxLength));
		return maxLength;
	}
	
	public void longestPal(String s) {
		if(s.length()<=0)
			return;
		int maxLength = 0;
		int start = 0;
		int low;
		int high;
		for(int i=1;i<s.length();i++)
		{
			low = i-1;
			high = i;
			while(low>=0 && high <s.length() && s.charAt(low)==s.charAt(high))
			{
				if(maxLength<high-low+1)
				{
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
			
			low = i-1;
			high = i+1;
			
			while(low>=0 && high < s.length() && s.charAt(low)==s.charAt(high))
			{
				if(maxLength>high-low+1)
				{
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
		}
		System.out.println(maxLength);
		System.out.println(s.substring(start,start+maxLength));
	}
	
}
