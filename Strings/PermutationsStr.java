
public class PermutationsStr {

	public void permute(StringBuilder s, int start, int end)
	{
		if(start==end)
		{
			System.out.println(s.toString()+" ");
			return;
		}
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
	
	private  void swap(StringBuilder s,int start, int end)
	{
		char temp = s.charAt(start);
		s.setCharAt(start, s.charAt(end));
		s.setCharAt(end, temp);
	}
	
	public static void main(String args[])
	{
		StringBuilder sb = new StringBuilder("ABC");
		PermutationsStr p = new PermutationsStr();
		int start = 0;
		int end =2;
		p.permute(sb, start, end);
		System.out.println(sb.toString());
	}
}
