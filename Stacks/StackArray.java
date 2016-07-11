
public class StackArray {
	private int[] arr;
	private int capacity;
	private int elements;
	public StackArray(int length)
	{
		capacity=length;
		arr = new int[capacity];
		elements=0;
	}
	public void push(int value)
	{
		if(isFull())
		{
			System.out.println("The stack is full ");
			return;
		}
		arr[elements++]=value;
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return 0;
		}
		int result=arr[elements-1];
		elements--;
		System.out.println("The popped element is "+result);
		return result;
	}
	public boolean isFull()
	{
		return elements==capacity;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public int peek()
	{
		return arr[elements-1];
	}
}
