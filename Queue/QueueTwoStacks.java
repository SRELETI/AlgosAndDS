
public class QueueTwoStacks {
	public int data;
	public QueueTwoStacks next;
	public QueueTwoStacks(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
