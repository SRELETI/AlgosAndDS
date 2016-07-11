
public class QueueTwoStacksMain {
	public static void main(String args[])
	{
		QueueTwoStacksQueue qtsq = new QueueTwoStacksQueue();
		qtsq.enqueue3(4);
		qtsq.enqueue3(3);
		qtsq.enqueue3(2);
		qtsq.enqueue3(1);
		System.out.println(qtsq.dequeue3());
		System.out.println(qtsq.dequeue3());
		System.out.println(qtsq.dequeue3());
		System.out.println(qtsq.dequeue3());
		/*qtsq.enqueue(4);
		qtsq.enqueue(3);
		qtsq.enqueue(2);
		qtsq.enqueue(1);
		qtsq.dequeue();
		qtsq.dequeue();
		qtsq.dequeue();
		qtsq.dequeue();
		qtsq.dequeue();
		qtsq.display();*/
		/*qtsq.enqueue2(4);
		qtsq.enqueue2(3);
		qtsq.enqueue2(2);
		qtsq.enqueue2(1);
		qtsq.dequeue2();
		qtsq.dequeue2();
		qtsq.dequeue2();
		qtsq.dequeue2();
		qtsq.dequeue2();
		//qtsq.enqueue2(0);
		qtsq.display2();*/
	}
}
