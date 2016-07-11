
public class StackReverse1 {
	private int maxSize;
	private char[] arr;
	private int top=-1;
	public StackReverse1(int length)
	{
		maxSize=length;
		arr=new char[maxSize];
		top=-1;
	}
	public void push(char value)
	{
		if(isFull())
		{
			System.out.println("The Stack is completely filled ");
		}
		else
		{
			arr[++top]=value;
			System.out.println("The newly inserted value is "+arr[top]);
		}
	}
	public Object pop()
	{
		if(isEmpty())
		{
			System.out.println("The Stack is empty, no items to delete");
			return null;
		}
		else
		{
			char result=arr[top];
			top--;
			return result;
		}
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public boolean isFull()
	{
		return top==maxSize-1;
	}
	public void peek()
	{
		System.out.println("The element at the top is "+arr[top]);
	}
}
