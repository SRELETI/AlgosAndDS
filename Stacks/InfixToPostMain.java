
public class InfixToPostMain {
	private String infix;
	private String postfix;
	private InfixToPost ifp;
	private int length;
	public InfixToPostMain(String in)
	{
		infix=in;
		length=infix.length();
		ifp = new InfixToPost(length);
		postfix="";
	}
	public void converter()
	{
		for(int i=0;i<length;i++)
		{
			char ch=infix.charAt(i);
			switch(ch)
			{
				case '(':
					ifp.push(ch);
					break;
				case ')':
					while(!ifp.isEmpty())
					{
						char popped = (char)ifp.pop();
						if(popped !='(')
							postfix=postfix+popped;
						else 
							break;
					} 
					break;
				case '+':
				case '-':
					goOperator(ch,1);
					break;
				case '*':
				case '/':
					goOperator(ch,2);
					break;
				default:
					postfix=postfix+ch;
			}
		}
		while(!ifp.isEmpty())
		{
			char popped=(char)ifp.pop();
			postfix=postfix+popped;
		}
		System.out.println(postfix);
	}
	public void goOperator(char value, int prec)
	{
		int prec2;
		if(ifp.isEmpty())
		{
			ifp.push(value);
			return;
		}
		else
		{
			while(!ifp.isEmpty())
			{
				char popped=(char)ifp.pop();
				if(popped=='(')
				{
					ifp.push(popped);
					break;
				}
				else
				{
					if(popped=='+' || popped == '-')
						prec2=1;
					else
						prec2=2;
					if(prec2<=prec)
					{
						ifp.push(popped);
						break;
					}
					else
					{
						postfix=postfix+popped;
					}
				}
			}
			ifp.push(value);
		}
	}
	public Object postFix()
	{
		Object result=null;
		for(int i=0;i<postfix.length();i++)
		{
			char ch=postfix.charAt(i);
		//	System.out.println(ch);
			if(ch>='0' && ch<='9')
				ifp.push(Character.digit(ch, 10));
			else
			{
				int num1=(int)ifp.pop();
				int num2=(int)ifp.pop();
				switch(ch)
				{
				case '+':
					result=num1+num2;
					break;
				case '-':
					result=num1-num2;
					break;
				case '*':
					result=num1*num2;
					break;
				case '/':
					result=num1/num2;
					break;
				}
				ifp.push((int)result);
			}
		}
		System.out.println(result);
		return result;
	}
}
