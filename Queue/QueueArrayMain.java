
public class QueueArrayMain {
	public static void main(String args[])
	{
		QueueArray qa = new QueueArray(4);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.enqueue(4);
		qa.dequeue();
		qa.enqueue(0);
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		System.out.println(qa.getRear());
		System.out.println(qa.getFront());
		//qa.display();
	}
}
