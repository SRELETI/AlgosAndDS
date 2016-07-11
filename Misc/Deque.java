
public class Deque {
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	private int elements;
	public Deque(int length)
	{
		maxSize=length;
		arr=new int[maxSize];
		rear=-1;
		front=0;
		elements=0;
	}
	public void insertRear(int value)
	{
		if(isFull())
		{
			System.out.println("The Deque is full");
			return;
		}
		if(rear==maxSize-1)
			rear=-1;
		rear++;
		elements++;
		arr[rear]=value;
		System.out.println("The newly inserted value at rear is "+arr[rear]);
	}
	public void insertFront(int value)
	{
		if(isFull())
		{
			System.out.println("The Deque is full");
			return;
		}
		if(front==0)
			front=maxSize;
		front--;
		arr[front]=value;
		elements++;
		System.out.println("The newly inserted value at front is "+arr[front]);
	}
	public int deleteFront()
	{
		if(isEmpty())
		{
			System.out.println("The Deque is empty");
			return Integer.MIN_VALUE;
		}
		int result=arr[front];
		front++;
		if(front==maxSize)
			front=0;
		elements--;
		System.out.println("The deleted value at front is "+result);
		return result;
	}
	public int deleteRear()
	{
		if(isEmpty())
		{
			System.out.println("The Deque is empty");
			return Integer.MIN_VALUE;
		}
		if(rear==-1)
			rear=maxSize-1;
		int result=arr[rear];
		rear--;
		elements--;
		System.out.println("The deleted value at rear is "+result);
		return result;
	}
	public boolean isFull()
	{
		return elements==maxSize;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
}
