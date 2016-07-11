
public class StackQueue {
	private QueueStackList qsl;
	private int count;
	private int count2;
	public StackQueue()
	{
		qsl = new QueueStackList();
		count=0;
	}
	public void push(int value)
	{
		qsl.enqueue2(value);
		while(!qsl.isEmpty())
		{
			int result=qsl.dequeue();
			qsl.enqueue2(result);
		}
		QueueStack temp=qsl.head;
		qsl.head=qsl.head2;
		qsl.head2=temp;
		count++;
	}
	public int pop()
	{
		int result=qsl.dequeue();
		count--;
		return result;
	}
	public boolean isEmpty()
	{
		return count==0;
	}
	public void push2(int value)
	{
		qsl.enqueue(value);
		count2++;
	}
	public int pop2()
	{
		int result=0;
		if(qsl.isEmpty2())
		{
			int temp_count=count2;
			while(!qsl.isEmpty())
			{
				temp_count--;
				result=qsl.dequeue();
				if(temp_count==0)
					break;
				else
					qsl.enqueue2(result);
			}
			QueueStack temp=qsl.head;
			qsl.head=qsl.head2;
			qsl.head2=temp;
			count2--;
			return result;
		}
		
		return 0;
	}
	public boolean isEmpty2()
	{
		return count2==0;
	}
}
