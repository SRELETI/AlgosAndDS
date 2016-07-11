
public class InfixToPostfix1 {
	private Object arr[];
	private int maxSize;
	private int elements;
	public InfixToPostfix1(int length)
	{
		maxSize=length;
		arr=new Object[maxSize];
		elements=-1;
	}
	public void push(Object value)
	{
		if(isFull())
		{
			System.out.println("The Stack is full");
		}
		else
		{
			arr[++elements]=value;
			
		}
	}
	public Object pop()
	{
			Object result=arr[elements];
			elements--;
			return result;
	}
	public boolean isFull()
	{
		return elements+1==maxSize;
	}
	public boolean isEmpty()
	{
		return elements==-1;
	}
}
