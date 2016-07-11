
public class Queue {
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	private int elements;
	public Queue(int length)
	{
		maxSize=length;
		arr=new int[maxSize];
		front =0;
		rear=-1;
		elements=0;
	}
	public void insert(int value)
	{
		if(isFull())
		{
			System.out.println("The queue is full, please wait for anyone to leave");
		}
		else
		{
			if(rear==maxSize-1)
				rear=-1;
			rear++;
			arr[rear]=value;
			System.out.println("The value newly inserted is "+arr[rear]);
			elements++;
		}
	}
	public void delete()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty, please wait for someone to join");
		}
		else
		{
			int result=arr[front];
			front++;
			if(front==maxSize)
				front=0;
			elements--;
			System.out.println("The deleted value is "+result);
		}
	}
	public boolean isFull()
	{
		return elements==maxSize;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public void display()
	{
		if(front<rear)
		{
			int length=elements;
					//rear-front+1;
			for(int i=0;i<length;i++)
			{
				if(front==maxSize)
					front=0;
				System.out.print(arr[front]+" ");
				front++;
			}
			//return;
		}
		else if(front>rear && elements!=0)
		{
			int length=elements;
					//maxSize-front+1;
			for(int i=0;i<length;i++)
			{
				if(front==maxSize)
					front=0;
				System.out.print(arr[front]+" ");
				front++;
			}
		}
		if(elements==1)
			System.out.println(arr[front]);
		if(elements==0)
			System.out.println("No Elements in the Stack");
		
	}
}
