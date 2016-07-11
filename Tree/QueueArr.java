
public class QueueArr {
	private TreePrint[] arr;
	private int size;
	private int elements;
	private int front;
	private int rear;
	
	public QueueArr(int length)
	{
		size = length;
		arr = new TreePrint[size];
		elements=0;
		front =0;
		rear = -1;
	}
	
	public void enqueue(TreePrint value)
	{
	//	System.out.print(size+" ");
	//	System.out.print(rear+" ");
		if(rear==size-1)
		{
			System.out.println("Full");
			return;
		}
		arr[++rear]=value;
		elements++;
	}
	
	public TreePrint dequeue()
	{
		if(front==size)
		{
			System.out.println("queue empty");
			return null;
		}
		TreePrint result=arr[front++];
		elements--;
		return result;
	}
	
	public TreePrint peek()
	{
		return arr[front];
	}
	
	public boolean isEmpty()
	{
		return elements==0;
	}
	public int size()
	{
		return elements;
	}
}
