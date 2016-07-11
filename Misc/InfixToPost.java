
public class InfixToPost {

	private Object[] arr;
	private int count;
	private int max_len;
	String output="";
	public InfixToPost(int length) {
		arr = new Object[length];
		max_len = length;
		count=0;
	}
	
	public void push(Object val) {
		if(isFull())
			return;
		arr[count++] = val;
	}
	
	public Object pop() {
		if(isEmpty())
			return null;
		Object temp = arr[--count];
		return temp;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public boolean isFull() {
		return count==max_len;
	}
	public Object peek()
	{
		if(isEmpty())
			return -1;
		return arr[count-1];
	}
	
	public void display() {
		for(int i=count-1;i>=0;i--)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	
	public void converter(String input) {
		if(input==null)
			return;
		
	//	InfixToPost ifp = new InfixToPost(input.length());
		for(int i=0;i<input.length();i++)
		{
			char ch = input.charAt(i);
			switch(ch) {
			
			case '(':
				push(ch);
				break;
			case ')':
				while(!isEmpty())
				{
					char temp = (char)pop();
					if(temp=='(')
						break;
					else
						output = output+temp;
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
				output= output+ch;
			}
		}
		
		while(!isEmpty())
			output = output + (char)pop();
		System.out.println(output);
	}
	
	private void goOperator(char ch, int prec1)
	{
		if(isEmpty())
		{
			push(ch);
			return;
		}
		int prec2;
		while(!isEmpty())
		{
			char ch_temp = (char)pop();
			if(ch_temp=='(')
			{
				push(ch_temp);
				break;
			}
			else
			{
				if(ch_temp =='+' || ch_temp=='-')
					prec2=1;
				else
					prec2=2;
				if(prec1>=prec2)
				{
					push(ch_temp);
					break;
				}
				else
				{
					output = output+ch_temp;
				}
			}
		}
		push(ch);
	}
		
	public static void main(String args[])
	{
		String output ="(2+(3*1))-9";
		InfixToPost i = new InfixToPost(output.length());
		
		i.converter(output);
		i.postFixEval();
	}
	
	public void postFixEval()
	{
		if(output=="")
			return;
		for(int i=0;i<output.length();i++)
		{
			char ch = output.charAt(i);
			if(ch!='-'&&ch!='+'&&ch!='*'&&ch!='/')
				push(Character.digit(ch, 10));
			else
			{
				int num = (int) pop();
				int num2 = (int) pop();
			//	System.out.println(num +" "+num2);
				int result=0;
				switch(ch){
				
				case '+':
					result = num+num2;
					break;
				case '-':
					result = num-num2;
					break;
				case '*':
					result = num*num2;
					break;
				case '/':
					result = num/num2;
					break;
				}
			//	System.out.println(result);
				push(result);
			}
		}
		System.out.println((int)pop());
	}
}
