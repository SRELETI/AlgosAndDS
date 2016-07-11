
public class LinkL {

	public int key;
	public LinkL next;
	
	public LinkL(int value)
	{
		key = value;
		next = null;
	}
	
	public void display()
	{
		System.out.print(key+" ");
	}
	
	public int getKey()
	{
		return key;
	}
}
