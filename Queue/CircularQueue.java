
public class CircularQueue {
	private int[] arr;
	private int capacity;
	private int front;
	private int rear;
	private int elements;
	public CircularQueue(int length)
	{
		capacity=length;
		arr = new int[capacity];
		front=0;
		rear=-1;
		elements=0;
	}
	public void enqueue(int value)
	{
		if(isFull())
		{
			System.out.println("Full");
			return;
		}
		if(rear==capacity-1)
			rear=-1;
		arr[++rear]=value;
		elements++;
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		if(front==capacity)
			front=0;
		int result=arr[front];
		front++;
		elements--;
		return result;
	}
	public boolean isFull()
	{
		return (elements==capacity);
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
}
