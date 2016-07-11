
public class DequeApp 
{
	public static void main(String args[])
	{
		int length=5;
		Deque q=new Deque(length);
		//q.insertFront(1);
		q.insertRear(2);
		//q.insertFront(3);
		q.insertRear(4);
		q.deleteFront();
		q.deleteFront();
	}
}
