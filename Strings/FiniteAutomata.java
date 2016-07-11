import java.util.Arrays;


public class FiniteAutomata {
	private final static int CHARS = 256;
	public void patternMatch(String text, String pattern)
	{
		int m = pattern.length();
		int n = text.length();
		
		int[][] TF= new int[m+1][CHARS];
		
		construct(TF,pattern,m);
		System.out.println(Arrays.deepToString(TF));
		int j=0;
		for(int i=0;i<n;i++)
		{
			j= TF[j][(int)(text.charAt(i))];
		
			if(j==m)
				System.out.println("Found at "+(i-m+1));
		}
		
	}
	
	private void construct(int[][] TF, String pattern, int m)
	{
		for(int i=0;i<CHARS;i++)
			TF[0][i]=0;
		TF[0][(int)(pattern.charAt(0))] = 1;
		
		int lps = 0;
		for(int i=1;i<=m;i++)
		{
			for(int j=0;j<CHARS;j++)
				TF[i][j] = TF[lps][j];
			if(i!=m)
				TF[i][(int)pattern.charAt(i)] = i+1;
			
			if(i<m)
				lps = TF[lps][(int)(pattern.charAt(i))];
		}
	}
	
	public static void main(String args[])
	{
		FiniteAutomata f = new FiniteAutomata();
		String pattern = "GEEKS";
		String text = "GEEKS FOR GEEKS";
		
		f.patternMatch(text, pattern);
	}
}
