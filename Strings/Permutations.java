
public class Permutations {

	public void permuteInput(String s)
	{
		StringBuilder ss  = new StringBuilder(s);
		int start = 0;
		int end = s.length()-1;
		permute(ss,start,end);
	}
	public void permute(StringBuilder s, int start, int end)
	{
		if(start==end)
			System.out.println(s.toString());
		else
		{
			for(int j=start;j<=end;j++)
			{
				swap(s,start,j);
				permute(s,start+1,end);
				swap(s,start,j);
			}
		}
	}
	
	public void swap(StringBuilder s, int first, int second)
	{
		char val = s.charAt(first);
		s.setCharAt(first, s.charAt(second));
		s.setCharAt(second, val);
		
	}
	
	public static void main(String args[])
	{
		Permutations p = new Permutations();
		String s ="ABCD";
		p.permuteInput(s);
	}
}
