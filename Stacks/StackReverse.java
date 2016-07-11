
public class StackReverse {
	private int[] arr;
	private int capacity;
	private int elements;
	public StackReverse(int length)
	{
		capacity=length;
		arr = new int[capacity];
		elements=0;
	}
	public void push(int value)
	{
		if(isFull())
			return;
		arr[elements++]=value;
	}
	public int pop()
	{
		if(isEmpty())
			return 0;
		int result=arr[elements-1];
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
	public void reverse()
	{
		int temp;
		if(!isEmpty())
		{
			temp=pop();
			reverse();
			insertAtBottom(temp);
		}
	}
	public void insertAtBottom(int temp)
	{
		if(isEmpty())
		{
			push(temp);
		}
		else
		{
			int temp2=pop();
			insertAtBottom(temp);
			push(temp2);
		}
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
