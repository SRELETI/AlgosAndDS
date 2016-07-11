
public class StackLL {
	public int value;
	public StackLL next;
	public StackLL(int val)
	{
		value=val;
		next=null;
	}
	public void display()
	{
		System.out.print(value+" ");
	}
}
