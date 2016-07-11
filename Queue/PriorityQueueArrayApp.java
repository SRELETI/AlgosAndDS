
public class PriorityQueueArrayApp {
	public static void main(String args[])
	{
		PriorityQueueArray pqa = new PriorityQueueArray(5);
		pqa.enqueue(1);
		pqa.enqueue(2);
		pqa.enqueue(3);
		pqa.enqueue(4);
		pqa.dequeue();
		pqa.enqueue(3);
		pqa.enqueue(6);
		pqa.dequeue();
		pqa.dequeue();
		pqa.dequeue();
		pqa.display();
	}
}
