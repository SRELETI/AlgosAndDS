
public class Rabin {
	private static final int d =256;
	public void rab(String text, String pattern)
	{
		int p_hash=0;
		int t_hash=0;
		int h=1;
		int q = 101;
		int m=pattern.length();
		int n= text.length();
		
		for(int i=0;i<m-1;i++)
		{
			h = (h*d)%q;
		}
		
		for(int i=0;i<m;i++)
		{
			p_hash = (p_hash*d + pattern.charAt(i))%q;
			t_hash = (t_hash*d + text.charAt(i))%q;
		}
		
		for(int i=0;i<=n-m;i++)
		{
			int j;
			if(p_hash == t_hash)
			{
				for(j=0;j<m;j++)
				{
					if(pattern.charAt(j)!=text.charAt(i+j))
						break;
				}
				if(j==m)
				{
					System.out.println("Found at "+i);
				}
			}
			if(i<n-m)
			{
				t_hash = (d*(t_hash-text.charAt(i)*h)+text.charAt(i+m))%q;
				if(t_hash<0)
				{
					t_hash = t_hash+q;
				}
			}
		}
		
	}
	
	public void naive(String text, String pattern)
	{
		int n= text.length();
		int m=pattern.length();
		for(int i=0;i<=n-m;i++)
		{
			int j;
			for(j=0;j<m;j++)
			{
				if(pattern.charAt(j)!=text.charAt(i+j))
					break;
			}
			if(j==m)
				System.out.println("Found at "+i);
		}
	}
	
	public void kmp(String text, String pattern)
	{
		int n = text.length();
		int m = pattern.length();
		int lps[] = new int[m];
		constructArr(lps,pattern,m);
		int i=0;
		int j=0;
		while(i<n)
		{
			if(pattern.charAt(j)==text.charAt(i))
			{
				i++;
				j++;
			}
			if(j==m)
			{
				System.out.println("Found at "+(i-j));
				j = lps[j-1];
			}
			else if(pattern.charAt(j)!=text.charAt(i))
			{
				if(j!=0)
				{
					j= lps[j-1];
				}
				else
					i=i+1;
			}
			
			
		}
	}
	
	private void constructArr(int[] lps, String pattern, int m)
	{
		lps[0]=0;
		int len = 0;
		int i=1;
		
		while(i<m)
		{
			if(pattern.charAt(i)==pattern.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					len = lps[len-1];
				}
				else
				{
					lps[i]=0;
					i++;
				}
			}
		}
	}
	
	public void another_naive(String text, String pattern)
	{
		int n= text.length();
		int m = pattern.length();
		for(int i=0;i<text.length();i++)
		{
			int j;
			for(j=0;j<m;j++)
			{
				if(pattern.charAt(j)!=text.charAt(i+j))
					break;
			}
			if(j==m)
			{
				System.out.println("Found at "+i);
				i=i+j;
			}
			else if(j==0)
			{
				i=i+1;
			}
			else
			{
				i=i+j;
			}
		}
	}
	public static void main(String args[])
	{
		Rabin r = new Rabin();
		String text = "FOR GEEKS";
		
		String pattern = "GEEK";
		r.rab(text, pattern);
		r.naive(text, pattern);
		r.kmp(text, pattern);
		r.another_naive(text, pattern);
	}
}
