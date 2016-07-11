
public class QueueTree {

	private TreePrintExt[] arr;
	private int front;
	private int rear;
	private int elements;
	private int total;
	public QueueTree(int length)
	{
		total = length;
		arr = new TreePrintExt[length];
		rear =-1;
		front =0;
		elements=0;
	}
	
	public void enqueue(TreePrintExt node)
	{
		if(isFull())
			return;
		arr[++rear]=node;
		elements++;
	}
	public TreePrintExt dequeue()
	{
		if(isEmpty())
			return null;
		TreePrintExt result = arr[front];
		front++;
		elements--;
		return result;
	}
	
	public boolean isFull()
	{
		return elements == total;
	}
	
	public boolean isEmpty()
	{
		return elements==0;
	}
	
	public TreePrintExt peek()
	{
		if(!isEmpty())
		{
			return arr[front];
		}
		return null;
	}
	
	public int size()
	{
		return elements;
	}
}
