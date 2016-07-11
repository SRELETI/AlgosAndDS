
public class LinkPriorityQueue {
	public int data;
	public LinkPriorityQueue next;
	public LinkPriorityQueue(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
