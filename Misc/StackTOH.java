
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class StackTOH {

	private int[] arr;
	private int capacity;
	private int top;
	
	public StackTOH(int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}
	
	public void push(int val) {
		if(isFull()) return;
		arr[++top] = val;
	}
	
	public int pop() {
		if(isEmpty()) return Integer.MIN_VALUE;
		int val = arr[top--];
		return val;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity-1;
	}
}
