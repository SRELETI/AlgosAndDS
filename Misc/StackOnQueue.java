
public class StackOnQueue {
	private int length;
	private Deque d;
	public StackOnQueue(int len)
	{
		length=len;
		d=new Deque(length);
	}
	public void push(int value)
	{
		d.insertFront(value);
	}
	public void pop()
	{
		d.deleteFront();
	}
	public boolean isEmpty()
	{
		return d.isEmpty();
	}
	public boolean isFull()
	{
		return d.isFull();
	}
}
