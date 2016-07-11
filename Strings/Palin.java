
public class Palin {

	public boolean find(String text)
	{
		int start = 0;
		int end = text.length();
		
		while(start<end)
		{
			if(text.charAt(start)!=text.charAt(end-1))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String args[])
	
	{
		String s = "geeksskeeg";
		Palin p = new Palin();
		System.out.println(p.find(s));
	}
}
