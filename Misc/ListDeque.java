
public class ListDeque {
	private ListD ld;
	public ListDeque()
	{
		ld=new ListD();
	}
	public void insertfirst(int data)
	{
		ld.insertFirst(data);
	}
	public void insertLast(int data)
	{
		ld.insertLast(data);
	}
	public void deleteFirst()
	{
		ld.deleteFirst();
	}
	public void deleteLast()
	{
		ld.deleteLast();
	}
	public void display()
	{
		ld.display();
	}
}
