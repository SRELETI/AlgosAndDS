
public class Reverse {

	public void reverse(String s, int start)
	{
		if(start<s.length())
		{
			reverse(s,start+1);
			System.out.print(s.charAt(start));
		}
	}
	
	public static void main(String args[])
	{
		Reverse r = new Reverse();
		
		String s = "Sudeep Reddy";
		r.reverse(s, 0);
	}
}
