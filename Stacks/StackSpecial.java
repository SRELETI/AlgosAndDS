
public class StackSpecial {
	public int data;
	public StackSpecial next;
	public StackSpecial(int value)
	{
		data=value;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
