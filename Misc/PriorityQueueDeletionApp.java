
public class PriorityQueueDeletionApp {
	public static void main(String args[])
	{
		int length=5;
		PriorityQueueDeletion pqd=new PriorityQueueDeletion(length);
		pqd.insert(5);
		pqd.insert(4);
		pqd.insert(3);
		pqd.insert(7);
		pqd.insert(1);
		pqd.pop();
	}
}
