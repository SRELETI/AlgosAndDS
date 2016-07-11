
public class InfixToPost {
	private Object[] arr;
	private int elements;
	private int capacity;
	public InfixToPost(int length)
	{
		capacity=length;
		arr = new Object[capacity];
		elements=0;
	}
	public void push(Object value)
	{
		if(isFull())
		{
			System.out.println("The stack is full ");
			return;
		}
		arr[elements++]=value;
	}
	public Object pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty");
			return 0;
		}
		Object result=arr[elements-1];
		elements--;
		return result;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public boolean isFull()
	{
		return elements==capacity;
	}
}