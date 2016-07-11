
public class StackExample {
	private int[] arr;
	int elements;
	int maxSize;
	public StackExample(int length)
	{
		maxSize=length;
		arr=new int[maxSize];
		elements=-1;
	}
	public void push(int value)
	{
		if(isFull())
		{
			System.out.println("THe Stack is already full");
		}
		else
		{
			elements++;
			arr[elements]=value;
		}
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("The Stack is empty, no items to delete");
		}
		else
		{
			int result=arr[elements];
			elements--;
			System.out.println("The popped up element is "+result);
		}
	}
	public int size()
	{
		return elements+1;
	}
	public int peek()
	{
		return arr[elements];
	}
	public boolean isFull()
	{
		return (elements+1==maxSize);
	}
	public boolean isEmpty()
	{
		return (elements==-1);
	}
}
