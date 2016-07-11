
public class StackAllInOne {
	
	public StackAllInOne() {
	}
	
	
	public void reverseStack(Stack_LinkedList s) {
		if(s.isEmpty()) 
			return ;
		int val = (int) s.pop();
		reverseStack(s);
		insertAfter(s,val);
	}
	
	public void insertAfter(Stack_LinkedList s, int val) {
		if(s.isEmpty()) {
			s.push(val);
			return;
		}
		int val2 = (int) s.pop();
		insertAfter(s,val);
		s.push(val2);
	}
	

	public static void main(String args[]) {
	/*	Stack_Array stackArray = new Stack_Array(10);
		
		stackArray.push(10);
		stackArray.push(20);
		stackArray.push(30);
		
		System.out.println(stackArray.isFull());
		
		System.out.println(stackArray.pop());
		
		System.out.println(stackArray.peek());
		
		System.out.println(stackArray.size());
		
		System.out.println(stackArray.pop());
		
		System.out.println(stackArray.pop());
		
		System.out.println(stackArray.pop());
		
		System.out.println(stackArray.size());
		
		System.out.println(stackArray.isEmpty());
		*/
	/*	Stack_LinkedList stackLL = new Stack_LinkedList();
		
		stackLL.push(10);
		stackLL.push(20);
		stackLL.push(30);
		
		System.out.println(stackLL.isFull());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.peek());
		System.out.println(stackLL.size());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.pop());
		System.out.println(stackLL.size());
		System.out.println(stackLL.isEmpty());
		*/
		Multiple_Stacks m = new Multiple_Stacks(6,3);
		
		m.push(1, 0);
		m.push(2,0);
		System.out.println(m.isEmpty(2));
		System.out.println(m.isEmpty(1));
		System.out.println(m.isEmpty(0));
		m.push(3, 1);
		m.push(4, 1);
		
		m.push(5, 2);
		
		System.out.println(m.isEmpty(2));
		System.out.println(m.isEmpty(1));
		System.out.println(m.isEmpty(0));
		System.out.println(m.isFull());
		m.push(6, 2);
		System.out.println(m.isFull());
		m.pop(2);
		System.out.println(m.isFull());
		System.out.println(m.isEmpty(2));
		m.push(6, 0);
		System.out.println(m.isEmpty(2));
		System.out.println(m.isFull());
	}
}

/*
 * Array Based Implementation of Stack
 * 
 * Problem with this implementation is that, the stack size is fixed at the time of initialization 
 * 
 */
class Stack_Array {
	// Array to hold Stack
	private int[] arr;
	// Current size of array
	private int cur_size;
	// Constructor
	public Stack_Array(int size) {
		arr = new int[size];
		cur_size=0;
	}
	
	// Push operation 
	public void push(int val) {
		// If stack is full, returns without inserting.
		// Else, inserts element at the top of the stack
		if(isFull()) return;
		arr[cur_size++]=val;
	}
	
	// Pop Operation 
	public int pop() {
		// If stack is empty, returns -1
		// Else returns the top element in the stack
		if(isEmpty()) return -1;
		int result = arr[--cur_size];
		return result;
	}
	
	// Checks if stack is empty
	public boolean isEmpty() { return cur_size==0; }
	// Checks if stack is full
	public boolean isFull() { return cur_size == arr.length; }
	// Returns the present size of the stack
	public int size() { return cur_size; }
	// Returns the top element of the stack
	public int peek() { return arr[cur_size-1]; }
}

/*
 *  Linked List based implementation of Stack
 *  
 *  No restrictions on size, it can grow dynamically, but needs extra memory for pointers
 *   
 */

class Stack_LinkedList {
	// head of the list
	public Link head;
	// constructor
	public Stack_LinkedList() {
		head = null;
	}
	
	// Push operation
	public void push(Object data) {
		// adds new node at the start of the list
		Link newNode = new Link(data);
		newNode.next = head;
		head = newNode;
	}
	
	// Pop operation
	public Object pop() {
		// removes node from the starting of the list, if list is empty, then it returns -1
		if(isEmpty()) return -1;
		Object result = head.data;
		head = head.next;
		return result;
	}
	
	// Checks if the list is empty
	public boolean isEmpty() { return head==null; }
	// Always returns false, as list will never be full
	public boolean isFull() { return false; }
	// Returns size of the list
	public int size() {
		Link cur = head;
		int count = 0;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
	// Returns the top element from the list
	public Object peek() { 
		if(isEmpty()) return -1;
		return head.data;
	}
}

/*
 * Utility class
 * 
 * Definition of node in the linked list that is used in the Linked List based implementation of stack
 */
class Link {
	public Object data;
	public Link next;
	
	public Link(Object val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

/* Creating Multiple stacks(k) using a single Array
 * 
 */
class Multiple_Stacks {
	
	/*
	 * For creating multiple stacks in a single array, we will create two extra stacks.
	 * 
	 * arr = main array containing the k stacks
	 * top = for storing the top element in all k stacks
	 * next = stores the next element of each item in arr
	 * free = stores the index of free spot
	 */
	
	private int[] arr;
	private int[] top;
	private int[] next;
	private int free;
	
	public Multiple_Stacks(int size, int stacks) {
		
		// size of array is declared and initialized.
		arr = new int[size];
		// size of top is stacks, as it stores only the top element in each stack
		top = new int[stacks];
		// size of next is set to size, as it stores next for all the elements in the array
		next = new int[size];
		
		free = 0;
		// Set top of each stack as -1, as there are no elements in any stack
		for(int i=0;i<top.length;i++) top[i] = -1;
		
		// Set next of ith element as i+1
		for(int i=0;i<next.length-1;i++) next[i] = i+1;
		
		// Set next of last element as -1, to indicate end of arr space.
		next[arr.length-1] = -1;
	}
	// Checks if arr is full
	public boolean isFull() { return free == -1; }
	
	// Checks if stack i is empty 
	// The value of stack is from 0 to k-1
	public boolean isEmpty( int stack) { return top[stack] == -1; }
	
	// Push method, value of stack is from 0 to k-1
	public void push(int val, int stack) {
		if(isFull()) {
			return;
		}
		// Get the free spot
		int i = free;
		// set free to next available free spot
		free = next[i];
		// set next of new item to previous top of the stack
		next[i] = top[stack];
		// set top of stack to present element
		top[stack] = i;
		// set val of present item
		arr[i] = val;
	}
	
	// Pop method, value of stack is from 0 to k-1
	public int pop(int stack) {
		if(isEmpty(stack)) {
			return -1;
		}
		// Get the element to be popped
		int i = top[stack];
		// set the top of the stack to new top
		top[stack] = next[i];
		// set of next popped element to free
		next[i] = free;
		// set free to the popped element
		free = i;
		// return popped element
		return arr[i];
		
	}
	
}