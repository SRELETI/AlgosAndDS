
public class PriorityQueueArray {
	private int[] arr;
	private int capacity;
	private int elements;
	private int front;
	private int rear;
	public PriorityQueueArray(int length)
	{
		capacity=length;
		elements=0;
		front=0;
		rear=-1;
		arr = new int[capacity];
	}
	public void enqueue(int value)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return;
		}
		else
		{
			if(isEmpty())
			{
				arr[++rear]=value;
				elements++;
			}
			else
			{
				elements++;
				int i=rear;
				while(i>=0 && value>arr[i])
				{
					arr[i+1]=arr[i];
					i--;
				}
				arr[i+1]=value;
				rear++;
			}
		}
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return 0;
		}
		int result=arr[front];
		front++;
		elements--;
		System.out.println("Dequeued element is "+result);
		return result;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public boolean isFull()
	{
		return elements==capacity || rear==capacity-1;
	}
	public void display()
	{
		for(int i = front;i<=rear;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
