import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Array Based implementation of Queue. 
 * 
 * Implementation is based on Circular Array
 */
class Queue_Arr {
	
	// Array to hold the stack
	private int[] arr;
	// front pointer to array
	private int front;
	// rear pointer to array
	private int rear;
	// total size of the array
	private int total_size;
	
	public Queue_Arr(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
		total_size = size;
	}
	
	// Enqueue operation
	public void enqueue(int val) {
		if(isFull()) return;
		// IF empty, create a node, i.e, set front and rear to a index 0.
		else if(isEmpty()) front = rear = 0;
		// if not empty, increment rear, modulus over total size is done to make it work even when the pointer moves to the frontend of array
		else rear = (rear+1)%total_size;
		// Set the current index to the given value
		arr[rear] = val;
	}
	
	public void dequeue() {
		if(isEmpty()) return;
		// if only element is present in the queue, then set front and rear to -1
		else if(front==rear) front = rear = -1;
		// increment front
		else front = (front +1)%total_size;
	}
	
	public boolean isFull() {
		// Check if queue is full
		return (rear+1)%total_size == front;
	}
	
	public boolean isEmpty() { 
		// Check if queue is empty
		return front == -1 && rear==-1;
	}
}

/*
 * Linked list implementation of Queue, Relatively easier to implement than the array based implementation.
 */
class Queue_Link2 {
	
	// Pointer to both the head and tail of the linkedlist
	private Link2 head;
	private Link2 tail;
	
	private int size;
	
	public Queue_Link2() {
		size = 0;
		head = null;
		tail = null;
	}
	
	// Enqueue 
	public void enqueue(int val) {
		Link2 newNode = new Link2(val);
		if(isFull()) return;
		else if(isEmpty()) head = newNode;
		else tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	// Dequeue 
	public void dequeue() {
		if(isEmpty()) return;
		else if(head==tail) head = tail = null;
		else head = head.next;
		size--;
	}
	// number of elements in queue
	public int size() {
		return size;
	}
	//Check if queue is full
	public boolean isFull() {
		return false;
	}
	
	// Check if queue is empty
	public boolean isEmpty() {
		return head == null;
	}
}


/*
 * Deque Array based implementation. Deque allows insertion and deletion from both ends. 
 * 
 * InsertFirst - Inserts from front
 * DeleteFirst - Deletes from front
 * 
 * InsertRear - Inserts from rear
 * DeleteRear - Deletes from rear
 * 
 * If insertion is done from one end and deletion is done from other end, then it will act as a Queue
 * If insertion and deletion is done from same end, then it will act as a Stack
 * 
 */

class Deque {
	// Array holding deque
	private int[] arr;
	// points to front and back of the array resp
	private int front;
	private int rear;
	// Size of the deque
	private int maxSize;
	
	public Deque(int size) {
		arr = new int[size];
		maxSize = size;
		// Initialized to -1
		front = -1;
		rear =-1;
	}
	
	// Inserting from the rear end
	public void insertRear(int val) {
		if(isFull()) return;
		// If deque is empty, assign a valid position for both pointers to start inserting
		else if(isEmpty()) front = rear = 0;
		// Else, just increment the rear, as we are inserting at rear.
		else rear = (rear+1)%maxSize;
		arr[rear] = val;
	}
	
	// Deleting from rear end
	public void deleteRear() {
		if(isEmpty()) return;
		// If there is only element in the Deque, then deleting it will make front and rear point to invalid positions again
		else if(rear==front) front = rear = -1;
		// Else just decrement the rear pointer, maxSize is added to deal with negative values
		else  rear = (rear+maxSize-1)%maxSize;
	}
	
	// Inserting from front end
	public void insertFirst(int val) {
		if(isFull()) return;
		// If we are inserting at front end for the first time, then make it point to front of the array, that is maxSize. i treated maxsize-1 index as front end
		else if(front==-1 || front ==0) front = maxSize-1;
		// else decrement the front pointer, maxSize is for dealing with negative values
		else front = (front+maxSize-1)%maxSize;
		arr[front] = val;
	}
	
	// Deleting from front end
	public void deleteFirst() {
		if(isEmpty()) return;
		// if  there is only element in the Deque, then deleting it will make front and rear point to invalid positions again
		else if( rear==front) front = rear = -1;
		// else increment the front pointer
		else front = (front+1)%maxSize;
	}
	// Checks if Deque is full
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	// Checks if Deque is empty
	public boolean isEmpty() {
		return rear==-1 || front==-1;
	}
}

/*
 * Linked list based implementation of Deque.
 * 
 */

class Deque_Link {
	
	// Pointers to start and end of the list
	private Link2 head;
	private Link2 tail;
	
	//constructor
	public Deque_Link() {
		head = null;
		tail = null;
	}
	// Insertion at front
	public void insertionFirst(int val) {
		if(isFull()) return;
		Link2 newNode = new Link2(val);
		newNode.next = head;
		head = newNode;
	}
	// Deletes the first node
	public void deleteFirst() {
		if(isEmpty()) return;
		head = head.next;
	}
	
	// Inserts after the last node
	public void insertionRear( int val) {
		if(isFull()) return;
		Link2 newNode = new Link2(val);
		tail.next = newNode;
		tail = newNode;
	}
	// Deletes the last node
	public void deleteRear() {
		if(isEmpty()) return;
		tail = tail.prev;
		tail.next = null;
	}
	// Checks if list is empty
	public boolean isEmpty() { return head==null;}
	// Checks if list is full, which is always false
	public boolean isFull() { return false; }
	
}

/*
 * Priority Queue implementation based on array:
 * 
 * Insertion takes O(N) time
 * Deletion takes O(1) time,
 * Inefficient compared to heap based implementation
 * 
 */

class Priority_Queue {
	// Array holding priority queue
	private int[] arr;
	// Size of the array
	private int size;
	// Current index of the array
	private int cur_index;
	// Constructor
	public Priority_Queue(int size) {
		this.size = size;
		arr = new int[size];
		cur_index = 0;
	}
	// Sorted insertion, sorted in ascending order
	public void insertion(int val) {
		if(isFull()) return;
		else if(isEmpty()) arr[cur_index++] = val;
		else {
			int i =cur_index-1;
			for(i=cur_index-1;i>=0;i--) {
				if(arr[i]>val) {
					arr[i+1] = arr[i];
				}
				else {
					break;
				}
			}
			arr[i+1] = val;
			cur_index++;
		}
	}
	
	// Deletes the highest element in the array
	public int deletion() {
		if(isEmpty()) return -1;
		return arr[cur_index--];
	}
	
	// Checks if the array is full
	public boolean isFull() {
		return cur_index == size;
	}
	// Checks if the array is empty
	public boolean isEmpty() {
		return cur_index==0;
	}
}


// Main Class for Testing all other classes
public class QueueAllInOne {

	public static void main(String args[]) {
	/*	
		Deque deq = new Deque(5);
		
		//Queue testing, inserting from Rear, deleting from front
		deq.insertRear(1);
		deq.insertRear(2);
		deq.insertRear(3);
		deq.insertRear(4);
		deq.insertRear(5);
		System.out.println(deq.isFull());
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		System.out.println(deq.isEmpty());
		
		//Stack Testing, inserting from rear, deleting from rear
		deq.insertRear(1);
		deq.insertRear(2);
		deq.insertRear(3);
		deq.insertRear(4);
		deq.insertRear(5);
		System.out.println(deq.isFull());
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		System.out.println(deq.isEmpty());
		
		//Stack Testing, opposite direction
		deq.insertFirst(1);
		deq.insertFirst(2);
		deq.insertFirst(3);
		deq.insertFirst(4);
		deq.insertFirst(5);
		System.out.println(deq.isFull());
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		deq.deleteRear();
		System.out.println(deq.isEmpty());
		
		//Queue Testing, opposite direction
		
		deq.insertFirst(1);
		deq.insertFirst(2);
		deq.insertFirst(3);
		deq.insertFirst(4);
		deq.insertFirst(5);
		System.out.println(deq.isFull());
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		deq.deleteFirst();
		System.out.println(deq.isEmpty());
		*/
		largestMultiple(new int[] {8,1,7,6,0});
	}
	
	
	/*
	 * Largest Multiple of 3 that can be formed from the given array of non-negative numbers
	 * 
	 */
	public static int[] largestMultiple(int[] arr) {
		if(arr==null || arr.length==0) return arr;
		
		Queue<Integer> q1 = new PriorityQueue<Integer>();
		Queue<Integer> q2 = new PriorityQueue<Integer>();
		Queue<Integer> q3 = new PriorityQueue<Integer>();
		
		Arrays.sort(arr);
		
		int sum= 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%3==0) {
				q1.add(arr[i]);
			}
			else if(arr[i]%3==1) {
				q2.add(arr[i]);
			}
			else 
				q3.add(arr[i]);
			sum += arr[i];
		}
		
		if(sum%3==2) {
			if(!q2.isEmpty()) {
				q2.remove();
			}
			else {
				if(!q1.isEmpty()) {
					q1.remove();
				}
				else 
					return null;
				if(!q1.isEmpty()) {
					q1.remove();
				}
				else 
					return null;
			}
		}
		else if(sum%3==1) {
			if(!q1.isEmpty()) {
				q1.remove();
			}
			else {
				if(!q2.isEmpty()) 
					q2.remove();
				else 
					return null;
				if(!q2.isEmpty()) 
					q2.remove();
				else
					return null;
			}
		}
		
		int top=0;
		while(!q1.isEmpty()) {
			arr[top++] = (int)q1.remove();
		}
		while(!q2.isEmpty()) {
			arr[top++] = (int) q2.remove();
		}
		
		while(!q3.isEmpty()) {
			arr[top++] = (int) q3.remove();
		}
		for(int i=top-1;i>=0;i--){
			System.out.print(arr[i]+" ");
		}
		return arr;
	}
	
	
}


/*
 * Implement multiple queues using a single array
 * 
 * To implement k queues in a array, we need 3 extra arrays
 * 
 * top[] - this array contains the top elements in each queue. Size is k.
 * rear[] - this array contains rear elements in each queue. Size is k.
 * next[] - this array stores the next element for each element in the array. Size is n.
 * free - stores the current free spot in the array
 * 
 */
class MultipleQueues_Array {
	
	private int[] arr;
	private int[] top;
	private int[] next;
	private int[] rear;
	private  int free;
	
	public MultipleQueues_Array(int size, int queues) {
		arr = new int[size];
		top = new int[queues];
		next = new int[size];
		rear = new int[queues];
		free = 0;
		
		for(int i=0;i<queues;i++) {
			top[i] = -1;
		}
		for(int  i=0;i<size-1;i++) {
			next[i]=i+1;
		}
		next[size-1] = -1;
	}
	
	public boolean isEmpty(int queue) { return top[queue]==-1; }
	public boolean isFull() { return free == -1; }
	public void enqueue(int val, int stack) {
		if(isFull()) {
			return;
		}
		
		int i = free;
		if(isEmpty(stack)) 
			top[stack]=i;
		else
			next[rear[stack]] = i;
		rear[stack] = i;
		next[i] = -1;
		arr[i] = val;
		
	}
	
	public void dequeue(int queue) {
		if(isEmpty(queue)) return;
		int i = top[queue];
		top[queue] = next[i];
		next[i] = free;
		free = i;
	}
}

/*
 * Utility Class
 * 
 * Link2 - Definition of Node in a LinkedList
 * 
 */
class Link2 {
	public int data;
	public Link2 next;
	public Link2 prev;
	
	public Link2(int val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
