
public class QueueStack {
	public int data;
	public QueueStack next;
	public QueueStack(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
