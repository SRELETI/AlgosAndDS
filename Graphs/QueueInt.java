
public class QueueInt {

	private int[] arr;
	private int elements;
	private int front;
	private int rear;
	private int size;
	
	public QueueInt(int size)
	{
		this.size = size;
		arr = new int[size];
		elements = 0;
		front = 0;
		rear = -1;
	}
	
	public void insert(int value)
	{
		arr[++rear] = value;
		elements++;
	}
	
	public int delete()
	{
		int result = arr[front++];
		elements--;
		return result;
	}
	
	public int peek()
	{
		return arr[front];
	}
	
	public boolean isempty()
	{
		return elements==0;
	}
	
	public boolean isFull()
	{
		return elements==size;
	}
}
