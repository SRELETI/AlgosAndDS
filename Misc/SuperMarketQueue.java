
public class SuperMarketQueue {
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	private int elements;
	public SuperMarketQueue(int length)
	{
		maxSize=length;
		arr=new int[maxSize];
		front=0;
		rear=-1;
		elements=0;
	}
	public void insert(int value)
	{
		if(isFull())
		{
			System.out.println("The queue line is full, please wait ");
			return;
		}
		if(rear==maxSize)
			rear=-1;
		rear++;
		arr[rear]=value;
		elements++;
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The Queue lines are empty, seams like the people are busy at home");
			return -1;
		}
		int result=arr[front];
		front++;
		if(front==maxSize)
			front=0;
		elements--;
		return result;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public boolean isFull()
	{
		return elements==maxSize;
	}
	public void display()
	{
		if(elements==0)
		{
			System.out.println("The Queue is empty");
			return;
		}
		else if(elements==1)
		{
			System.out.println(arr[front]);
			return;
		}
		else
		{
			int j=front;
			for(int i=0;i<elements;i++)
			{
				System.out.print(arr[j]+" ");
				j++;
				if(j==maxSize)
					j=0;
			}
			System.out.println();
		}
	}
}
