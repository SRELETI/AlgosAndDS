
public class Balancepar2 {
	private String par;
	private int length;
	Balancepar stackk;
	public Balancepar2(String in)
	{
		length=in.length();
		stackk = new Balancepar(length);
		par=in;
	}
	public boolean convert()
	{
		for(int i=0;i<par.length();i++)
		{
			char ch = par.charAt(i);
			switch(ch)
			{
			case '(':
			case '{':
			case '[':
				stackk.push(ch);
				break;
			case '}':
			case ')':
			case ']':
				if(!stackk.isEmpty())
				{
					char ch1=stackk.pop();
					if(ch=='}' && ch1 !='{' || ch==']' && ch1!='[' || ch==')' && ch1!='(')
					{
						System.out.println("Left paranthesis is not matching ");
						return false;
					}
				}
				else
				{
					System.out.println("Left paranthesis not inserted ");
					return false;
				}
			}
		}
		if(!stackk.isEmpty())
		{
			System.out.println("Right paranthesis missing");
			return false;
		}
		return true;
	}
}
