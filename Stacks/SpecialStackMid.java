
public class SpecialStackMid {
	public int data;
	public SpecialStackMid next;
	public SpecialStackMid prev;
	
	public SpecialStackMid(int value)
	{
		data=value;
		next=null;
		prev=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
