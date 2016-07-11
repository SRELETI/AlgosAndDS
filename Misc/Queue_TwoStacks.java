
public class Queue_TwoStacks {

	private Stack_Array first;
	private Stack_Array second;
	
	public Queue_TwoStacks(int val) {
		first = new Stack_Array(val);
		second  = new Stack_Array(val);
	}
	
	public void enqueue(int val) {
		if(isFull()) return;
		if(first.isEmpty() && second.isEmpty()) {
			first.push(val);
			return;
		}
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		first.push(val);
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
	}
	
	public int dequeue() {
		if(isEmpty()) return -1;
		return first.pop();
	}
	
	public boolean isEmpty() {
		return first.isEmpty();
	}
	
	public boolean isFull() {
		return first.isFull();
	}
	
	public static void main(String args[]) {
		Queue_TwoStacks queue = new Queue_TwoStacks(3);
		
		System.out.println(queue.dequeue());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.isFull());
		
		queue.enqueue(5);
	}
}
