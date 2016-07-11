class Stacksss {
	private int[] arr;
	private int count;
	private int max_count;
	
	public Stacksss( int length) {
		arr = new int[length];
		count = 0;
		max_count = length;
	}
	
	public void push(int val) {
		if(isFull())
			return;
		arr[count++] = val;
	}
	
	public int pop() {
		if(isEmpty())
			return -1;
		int temp = arr[--count];
		return temp;
	}
	
	public boolean isFull() {
		return count == max_count;
	}
	
	public boolean isEmpty() {
		return count ==0;
	}
	
	public int peek() {
		if(isEmpty())
			return -1;
		return arr[count-1];
	}
}

public class QueueStacks {
	private Stacksss s1;
	private Stacksss s2;
	
	public QueueStacks(int length) {
		s1 = new Stacksss(length);
		s2 = new Stacksss(length);
	}
	
	public void enqueue(int val) {
		if(isFull())
			return;
		s1.push(val);
	}
	
	public int dequeue() {
		if(isEmpty())
			return -1;
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public boolean isFull() {
		return s2.isFull();
	}
	
	public boolean isEmpty() {
		return s2.isEmpty();
	}
	
	public static void main(String args[])
	{
		QueueStacks q = new QueueStacks(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
