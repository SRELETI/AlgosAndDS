
public class Badheur {
	private final static int CHARS = 256;
	public void badCheck(String text, String pattern)
	{
		int m = pattern.length();
		int n = text.length();
		
		int[] bad = new int[CHARS];
		
		construct(bad,pattern,m);
		
		int s=0;
		
		int j;
		
		while(s<=(n-m))
		{
			j = m-1;
			while(j>=0 && pattern.charAt(j)==text.charAt(s+j))
				j--;
			if(j<0)
			{
				System.out.println("Found at " +s);
				
				s = s+ ((s+m)<n ? (m-bad[(int)text.charAt(s+m)]) : 1);

			}
			else
			{
				s = s + Math.max(1, j-bad[(int)text.charAt(s+j)]);
			}
		}
	}
	
	private void construct(int[] bad, String pattern, int m)
	{
		for(int i=0;i<m;i++)
			bad[(int)pattern.charAt(i)]=i;
	}
	
	public static void main(String args[])
	{
		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEKS";
		
		Badheur b = new Badheur();
		b.badCheck(text, pattern);
	}
}
