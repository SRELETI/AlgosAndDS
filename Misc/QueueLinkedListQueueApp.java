
public class QueueLinkedListQueueApp {
	public static void main(String args[])
	{
		QueueLinkedListQueue q=new QueueLinkedListQueue();
		q.push(4);
		q.push(3);
		q.push(2);
		q.push(1);
		q.display();
		while(!q.isEmpty())
		{
			q.pop();
		}
	}
}
