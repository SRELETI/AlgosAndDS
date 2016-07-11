import java.util.Stack;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class TwoStacksInArray {

	private int[] arr;
	private int size;
	private int start;
	private int end;
	
	public TwoStacksInArray(int size) {
		arr = new int[size];
		this.size = size;
		start = 0;
		end = size;
	}
	
	public void push1(int val) {
		if(isFull()) {
			System.err.println("Stack is Full: Top");
			return;
		}
		arr[start++] = val;
	}
	
	public void push2(int val) {
		if(isFull()) {
			System.err.println("Stack is Full: Bottom");
			return;
		}
		arr[--end] = val;
	}
	
	public int pop1() {
		if(isEmpty1()) {
			System.err.println("Stack is Empty: Top");
			return -1;
		}
		int result = arr[--start];
		return result;
	}
	
	public int pop2() {
		if(isEmpty2()) {
			System.out.println("Stack is Empty: Bottom");
			return -1;
		}
		int result = arr[end];
		end++;
		return result;
	}
	
	public boolean isFull() {
		return start == end;
	}
	
	public boolean isEmpty1() {
		return start ==0 ;
	}
	
	public boolean isEmpty2() {
		return end == size;
	}
 }
