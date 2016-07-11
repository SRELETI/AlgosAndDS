class QueueSpec {
	private int[] arr;
	private int front;
	private int end;
	public int max_count;
	public int count;
	public QueueSpec(int val) {
		arr = new int[val];
		front =-1;
		end = 0;
		count= 0;
		max_count = val;
	}
	
	public void enqueue(int val) {
		if(isFull())
			return;
		arr[end++] = val;
		count++;
		if(end==max_count)
			end = 0;
	}
	
	public int dequeue() {
		if(isEmpty())
			return -1;
		int temp = arr[++front];
		if(front==max_count-1)
			front = -1;
		count--;
		return temp;
	}
	
	public boolean isFull() {
		return count == max_count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
}

public class StackQueue {
	private QueueSpec q1;
	private QueueSpec q2;
	
	public StackQueue(int length) {
		q1 = new QueueSpec(length);
		q2 = new QueueSpec(length);
	}
	
	public void push(int val) {
		if(isFull())
			return;
		q2.enqueue(val);
	}
	
	public int pop() {
		if(isEmpty())
			return -1;
		int count = q2.count;
		int temp = -1;
		while(!q2.isEmpty())
		{
			temp =q2.dequeue();
			if(count==1)
				break;
			count--;
			q1.enqueue(temp);
		}
		QueueSpec temp2 = q1;
		q1 = q2;
		q2 = temp2;
		return temp;
		
	}
	
	public boolean isFull() {
		return q2.isFull();
	}
	
	public boolean isEmpty() {
		return q2.isEmpty();
	}
	
	public static void main(String args[]) {
		StackQueue s = new StackQueue(5);
		s.push(5);
		s.push(4);
		s.push(3);
		
		System.out.println(s.pop());
		s.push(2);
		s.push(1);
		System.out.println(s.pop());
	}
}
