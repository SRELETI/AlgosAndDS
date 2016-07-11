
public class Permut {

	public void permut(StringBuilder s, int start, int end)
	{
		if(start==end)
		{
			System.out.println(s.toString());
			return;
		}
		for(int j=start;j<=end;j++)
		{
			swap(s,j,start);
			permut(s,start+1,end);
			swap(s,j,start);
		}
	}
	
	private void swap(StringBuilder s,int po1, int po2)
	{
		char temp = s.charAt(po1);
		s.setCharAt(po1, s.charAt(po2));
		s.setCharAt(po2, temp);
	}
	
	public static void main(String args[])
	{
		StringBuilder s =new StringBuilder("ABC");
		Permut p = new Permut();
		p.permut(s, 0, 2);
	}
}
