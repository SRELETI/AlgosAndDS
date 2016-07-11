
public class SubString {

	public void subString(String text)
	{
		for(int i=0;i<text.length();i++)
		{
			for(int j=i+1;j<=text.length();j++)
			{
				System.out.print(text.substring(i, j));
			}
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		SubString s = new SubString();
		
		String text = "fun";
	//	s.subString(text);
		s.callSub(text);
		
	}
	
	public void callSub(String s)
	{
		subS(s,0,1);
	}
	
	public void subS(String s, int start, int end)
	{
		while(true)
		{
			if(start == s.length() && end == s.length())
				break;
			else if( end == s.length()+1)
			{
				int temp = start+1;
				start = start+1;
				end  = temp;
			}
			else
			{
			//	System.out.print(start+" "+end+" ");
				System.out.print(s.substring(start, end)+" ");
				end = end+1;
			}
		}
		
	}
}
