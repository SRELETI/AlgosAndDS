
public class StackUndoRedo {
	public int data;
	public StackUndoRedo next;
	public StackUndoRedo(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
