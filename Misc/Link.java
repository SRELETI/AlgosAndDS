
public class Link {
	public int data;
	public long ldata;
	public Link next;
	public Link(int da, long daa)
	{
		data=da;
		ldata=daa;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" "+ldata+" ");
	}
}
