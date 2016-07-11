
public class Deq {

	private int[] data;
	private int front;
	private int rear;
	private int elements;
	private int size;
	
	public Deq(int size)
	{
		this.size= size;
		data = new int[size];
		front =-1;
		rear = 0;
		elements = 0;
	}
	
	public void enqueue_back(int val)
	{
		if(isFull())
		{
			System.out.println("Full");
			return;
		}
		data[rear++] = val;
		elements++;
	}
	
	public void enqueue_front(int val)
	{
		if(isFull())
		{
			System.out.println("Full");
			return;
		}
		data[front--] = val;
		elements++;
	}
	
	public int dequeue_front()
	{
		if(isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		int temp = data[++front];
		elements--;
		return temp;
	}
	public int dequeue_back()
	{
		if(isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		int temp = data[--rear];
		elements--;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return elements==0;
	}
	
	public boolean isFull()
	{
		return elements==size;
	}
	public void display()
	{
		for(int i=front+1;i<rear;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public int back()
	{
		if(isEmpty())
			return -1;
		return data[rear-1];
	}
	public int front()
	{
		if(isEmpty())
			return -1;
		return data[front+1];
	}
}
