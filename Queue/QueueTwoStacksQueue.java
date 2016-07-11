
public class QueueTwoStacksQueue {
	private QueueTwoStacksStack stack1;
	private QueueTwoStacksStack stack2;
	public QueueTwoStacksQueue()
	{
		stack1= new QueueTwoStacksStack();
		stack2= new QueueTwoStacksStack();
	}
	public void enqueue(int value)
	{
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		stack1.push(value);
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}
	public int dequeue()
	{
		if(stack1.isEmpty())
		{
			System.out.println("The queue is empty");
			return 0;
		}
		int result=stack1.pop();
		return result;
	}
	public void enqueue2(int value)
	{
		stack1.push(value);
	}
	public int dequeue2()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
		{
			System.out.println("Nothing to dequeue ");
			return 0;
		}
		else
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}
	public void display()
	{
		stack1.display();
	}
	public void display2()
	{
		stack2.display();
		stack1.display();
	}
	public void enqueue3(int value)
	{
		stack1.push(value);
	}
	public int dequeue3()
	{
		if(stack1.isEmpty())
		{
			System.out.println("The stack is empty");
			return 0;
		}
		if(stack1.isOneLength())
		{
			int result=stack1.pop();
			//System.out.println(result);
			return result;
		}
		else
		{
			int popped=stack1.pop();
			int result=dequeue3();
			stack1.push(popped);
			//System.out.println(result);
			return result;
		}
	}
}
