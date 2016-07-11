
public class LinkedListPriorityQueueApp {
	public static void main(String args[])
	{
		LinkedListPriorityQueue lpq = new LinkedListPriorityQueue();
		lpq.enqueue(1);
		lpq.enqueue(2);
		lpq.enqueue(3);
		lpq.enqueue(0);
		lpq.enqueue(7);
		lpq.enqueue(4);
		/*lpq.dequeue();
		lpq.dequeue();
		lpq.dequeue();
		lpq.dequeue();*/
		lpq.display();
	}
}
