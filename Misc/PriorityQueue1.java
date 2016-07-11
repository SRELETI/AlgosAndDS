
public class PriorityQueue1 {
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	private int elements;
	public PriorityQueue1(int length)
	{
		maxSize=length;
		arr=new int[maxSize];
		front=0;
		rear=-1;
		elements=0;
	}
	public void insertion(int value)
	{
		int i;
		if(isFull())
		{
			System.out.println("The Queue is already full");
		}
		else
		{
			if(isEmpty())
			{
				arr[++rear]=value;
				elements++;
				System.out.println("newly inserted "+arr[rear]);
			}
			else
			{
				for(i=elements-1;i>=0;i--)
				{
					if(value>arr[i])
						arr[i+1]=arr[i];
					else
						break;
				}
				arr[i+1]=value;
				System.out.println("The newly inserted value "+arr[i+1]);
				rear++;
				elements++;
			}
		}
	}
	public void delete()
	{
		if(isEmpty())
		{
			System.out.println("The Queue is already empty");
		}
		else
		{
			int result=arr[front];
			front++;
			elements--;
			System.out.println("The element that is deleted is "+result);
		}
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
	public boolean isFull()
	{
		return elements==maxSize;
	}
}
