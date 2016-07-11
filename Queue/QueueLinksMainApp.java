
public class QueueLinksMainApp {
	public static void main(String args[])
	{
		QueueLinksMain qsm = new QueueLinksMain();
		qsm.enqueue(4);
		qsm.enqueue(3);
		qsm.enqueue(2);
		System.out.println(qsm.getFirst());
		System.out.println(qsm.getLast());
		qsm.display();
		qsm.dequeue();
		qsm.dequeue();
		qsm.dequeue();
		qsm.dequeue();
	}
}
