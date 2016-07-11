
public class QueueLinks {
	public int data;
	public QueueLinks next;
	public QueueLinks(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
