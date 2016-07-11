
public class ArrLink {

	public int data;
	public ArrLink next;
	public ArrLink prev;
	
	public ArrLink(int val)
	{
		data = val;
		next = null;
		prev = null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}
