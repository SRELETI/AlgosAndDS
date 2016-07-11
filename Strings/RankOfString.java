import java.util.HashMap;


public class RankOfString {

	public void rank(String text)
	{
		int len = text.length();
		int fact = factorial(len);
		int rank = 1;
		for(int i=0;i<text.length();i++)
		{
			fact = fact/(len-i);
			
			int rightCount = getnextSmall(text, i,len);
			
			rank = rank + (rightCount * fact);
		}
		System.out.println(rank);
	}
	
	private int getnextSmall(String text, int start, int end)
	{
		int count = 0;
		for(int i=start+1;i<end;i++)
		{
			if(text.charAt(i)<text.charAt(start))
				count++;
		}
		return count;
		
	}
	
	private int factorial(int len)
	{
		if(len==1)
			return 1;
		return len * factorial(len-1);
	}
	
	public void rank2(String text)
	{
		int len = text.length();
		int fact = factorial(len);
		int[] count = new int[256];
		populateArray(text,count);
		int rank =1;
		for(int i =0;i<text.length();i++)
		{
			fact = fact/(len-i);
			int countright = count[((int)text.charAt(i))-1]*fact;
			rank = rank + countright;
			update(count,text.charAt(i));
		}
		System.out.println(rank);
	}
	
	private void update(int[] count, char ch)
	{
		for(int i=(int)ch;i<256;i++)
			count[i]--;
	}
	
	private void populateArray(String text, int[] count)
	{
		for(int i=0;i<text.length();i++)
		{
			count[(int)text.charAt(i)] = 1;
		}
		
		for(int i=1;i<256;i++)
		{
			count[i]=count[i]+count[i-1];
		}
	}
	
	
	public static void main(String args[])
	{
		String s = "STRING";
		RankOfString r = new RankOfString();
		r.rank(s);
		r.rank2(s);
	}
}
