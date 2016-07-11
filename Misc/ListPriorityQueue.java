
public class ListPriorityQueue {
	private ListPQ lpq;
	public ListPriorityQueue()
	{
		lpq=new ListPQ();
	}
	public void insert(int key)
	{
		lpq.insert(key);
	}
	public void delete()
	{
		lpq.delete();
	}
	public void displayed()
	{
		System.out.println("The elements in the queue are ");
		lpq.display();
	}
}
