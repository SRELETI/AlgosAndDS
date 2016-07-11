
public class InfixToPostfix2 {
	private String infix;
	private String postfix;
	int length;
	InfixToPostfix1 ifp;
	public InfixToPostfix2(String in)
	{
		infix=in;
		length=infix.length();
		ifp= new InfixToPostfix1(length);
		postfix="";
	}
	public String converter()
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
						Object item=ifp.pop();
						if(item!="(")
							postfix=postfix+item;
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
					break;
						
			}
		}
		while(!ifp.isEmpty())
		{
			postfix=postfix+ifp.pop();
		}
		return postfix;
	}
	public void goOperator(char ch,int value)
	{
		if(ifp.isEmpty())
			ifp.push(ch);
		else
		{
			while(!ifp.isEmpty())
			{
				Object chx=ifp.pop();
				if(chx=="(")
				{
					ifp.push(chx);
					break;
				}
				else
				{
					int prec2;
					if(chx=="+" || chx=="-")
					{
						prec2=1;
					}
					else
						prec2=2;
					if(value<=prec2)
						postfix=postfix+chx;
					else
					{
						ifp.push(chx);
						break;
					}
				}
			}
			ifp.push(ch);
		}
	}
	public Object postfixvalue(String postfix)
	{
		char ch;
		Object result=null;
		for(int i=0;i<postfix.length();i++)
		{
			ch=postfix.charAt(i);
			if(ch>='0' && ch <='9')
				ifp.push((int)ch);
			else
			{
				int num1;
				num1=(int)ifp.pop();
				int num2;
				num2=(int)ifp.pop();
				switch(ch)
				{
				case '+':
					result=(num1)+(num2);
					break;
				case '-':
					result=(int)num1-(int)num2;
					break;
				case '*':
					result=(int)num1*(int)num2;
					break;
				case '/':
					result=(int)num1/(int)num2;
					break;
				}
				ifp.push(result);
			}
		}
		return ifp.pop();
	}
}
