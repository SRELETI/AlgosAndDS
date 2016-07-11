
public class QueueArray {
	private int[] arr;
	private int capacity;
	private int front;
	private int rear;
	public QueueArray(int length)
	{
		capacity=length;
		arr = new int[capacity];
		front=0;
		rear=-1;
	}
	public void enqueue(int value)
	{
		if(isFull())
		{
			System.out.println("The Stack is full ");
			return;
		}
		rear++;
		arr[rear]=value;
	}
	public int peek()
	{
		return arr[front];
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return -1;
		}
		int result=arr[front];
		front++;
		return result;
	}
	public boolean isEmpty()
	{
		return rear==-1 || front==capacity;
	}
	public boolean isFull()
	{
		return rear==capacity-1;
	}
	public int getFront()
	{
		if(isEmpty())
		{
			System.out.println("No Elements in the queue");
			return -1;
		}
		return arr[front];
	}
	public int getRear()
	{
		if(isEmpty())
		{
			System.out.println("No Elements in the queue ");
			return -1;
		}
		return arr[rear];
	}
	public void display()
	{
		for(int i=front;i<=rear;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
