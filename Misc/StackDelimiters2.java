
public class StackDelimiters2 {
	private String input;
	public StackDelimiters2(String in)
	{
		input= in;
	}
	public void check()
	{
		int maxsize=input.length();
		StackDelimiters1 sd=new StackDelimiters1(maxsize);
		for(int i=0;i<maxsize;i++)
		{
			char ch=input.charAt(i);
			switch(ch)
			{
				case '{':
				case '[':
				case '(':
					sd.push(ch);
					break;
				case '}':
				case ']':
				case ')':
					if(!sd.isEmpty())
					{
						char chx=sd.pop();
						if((ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(')) 
						{
							System.out.println("The Delimiter "+chx+" is not closed properly");
						}
					}
					else
					{
						System.out.println("No opening delimiter for "+ch);
					}
					break;
					default:
						break;
			}
		}
		if(!sd.isEmpty())
			System.out.println("Missing closing delimiters");

		}
	}
