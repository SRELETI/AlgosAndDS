
public class StackDelimiters1 {
	private char[] arr;
	private int maxSize;
	private int top;
	public StackDelimiters1(int length)
	{
		maxSize=length;
		arr=new char[maxSize];
		top=-1;
	}
	public void push(char value)
	{
		if(isFull())
		{
			System.out.println("The Stack is full");
		}
		else
		{
			arr[++top]=value;
		}
	}
	public char pop()
	{
			return arr[top--];
	}
	public boolean isFull()
	{
		return top+1==maxSize;
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
}
