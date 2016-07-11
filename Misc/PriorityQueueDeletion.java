
public class PriorityQueueDeletion {
	private int length;
	private int[] arr;
	private int front;
	private int rear;
	private int element;
	public PriorityQueueDeletion(int leng)
	{
		length=leng;
		arr=new int[length];
		rear=-1;
		front=0;
		element=0;
	}
	public void insert(int value)
	{
		if(isFull())
			System.out.println("The Queue is full");
		element++;
		arr[++rear]=value;
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty");
			return Integer.MIN_VALUE;
		}
		int item=front;
		for(int i=1;i<element;i++)
		{
			if(front+i==length)
				front=0-i;
			if(arr[item]<arr[front+i])
			{
				item=front+i;
			}
		}
		int temp=arr[item];
		arr[item]=arr[front];
		arr[front]=temp;
		int result=arr[front];
		front--;
		element--;
		System.out.println("The deleted element is "+result);
		return result;
	}
	public boolean isEmpty()
	{
		return element==0;
	}
	public boolean isFull()
	{
		return element==length;
	}
}
