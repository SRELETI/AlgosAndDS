
public class QueueNoCount {
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	public QueueNoCount(int length)
	{
		maxSize=length+1;
		arr=new int[maxSize];
		front=0;
		rear=-1;
	}
	public void insert(int value)
	{
		if(isFull())
		{
			System.out.println("The queue is full");
		}
		else
		{
			if(rear==maxSize-2)
				rear=-1;
			rear++;
			arr[rear]=value;
			System.out.println("The value inserted is" + arr[rear]);
		}
	}
	public void delete()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty");
		}
		else
		{
			int result=arr[front];
			front++;
			if(front==maxSize-1)
				front=0;
			System.out.println("The Value deleted is "+result);
		}
	}
	public boolean isFull()
	{
		return (rear-2==front || (front+maxSize-2)==rear);
	}
	public boolean isEmpty()
	{
		return (rear-1==front || (front+maxSize-1==rear));
	}
	public void isSize()
	{
		if(rear>=front)
			System.out.println("The size is "+(rear-front+1));
		else
			System.out.println("size program not complete");
	}
}
