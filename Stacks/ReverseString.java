
public class ReverseString {
	private InfixToPost itp;
	private String input;
	private String reverse;
	public ReverseString(String in)
	{
		input=in;
		reverse="";
		itp = new InfixToPost(input.length());
	}
	public void converter()
	{
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			itp.push(ch);
		}
		while(!itp.isEmpty())
		{
			char ch=(char)itp.pop();
			reverse=reverse+ch;
		}
		System.out.println(reverse);
	}
	
}
