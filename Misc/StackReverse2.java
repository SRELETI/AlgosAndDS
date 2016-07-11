
public class StackReverse2 {
	String input;
	String output;
	public StackReverse2(String in)
	{
		input=in;
	}
	public String Reverse()
	{
		int length=input.length();
		StackReverse1 sr=new StackReverse1(length);
		for(int i=0;i<length;i++)
		{
			sr.push(input.charAt(i));
		}
		sr.push('s');
		output="";
		for(int i=0;i<length;i++)
		{
			Object ch=sr.pop();
			output=output+ch;
		}
		return output;
	}
}
