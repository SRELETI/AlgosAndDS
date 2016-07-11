
public class QueueApp {
	public static void main(String args[])
	{
		int length=5;
		Queue q=new Queue(length);
		System.out.println(q.isEmpty());
		q.insert(3);
		q.insert(4);
		q.insert(5);
		q.delete();
		q.insert(6);
		q.insert(7);
		//q.insert(8);
		System.out.println(q.isFull());
		System.out.println(q.isFull());
		q.display();
	}
}
