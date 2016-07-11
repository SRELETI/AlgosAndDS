import java.util.Arrays;


/*
 * Implementation of Heap Data Structure
 * 
 */
public class Heap {
	
	// Array Holding the heap
	private int[] arr;
	// holds the current size of heap
	private int cur_size;
	// Constructor
	public Heap(int size) {
		this.cur_size = 0;
		arr = new int[size];
	}
	
	// Inserts new value at the position pointed by cur_size, which is always the next available position in the array
	// Then tickleup the inserted value to the correct position in the heap
	public void insert(int val) {
		if(cur_size>=arr.length) { 
			System.out.println("Oops, size exceeded");
			return;
		}
		arr[cur_size] = val;
		tickleUp(cur_size++);
	}
	
	// Removes the value from the start of the array, and copies the value at end of the array to the start of the array
	// Then tickledown the newly replaced value to the correct position in the heap
	public int remove() {
		if(cur_size==0) return -1;
		int result = arr[0];
		arr[0] = arr[--cur_size];
		tickleDown(0);
		return result;
	}
	
	// Tickle up function, has to compare its value with its parent only.
	private void tickleUp(int index) {
		int parent = (index-1)/2;
		int val = arr[index];
		while(index>0 && val>arr[parent]) {
			arr[index] = arr[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		arr[index] = val;
	}
	
	// Tickles down function, has to compare its value with both its childs.
	private void tickleDown(int index) {
		int lchild;
		int rchild;
		int result;
		int val = arr[index];
		while(index<cur_size/2) {
			lchild = 2*index+1;
			rchild = 2*index+2;
			if(rchild<cur_size && arr[rchild]>arr[lchild])
				result = rchild;
			else 
				result = lchild;
			if(arr[result]<val) 
				break;
			arr[index] = arr[result];
			index = result;
		}
		arr[index] = val;
		
	}
	
	public static void main(String args[]) {
	/*	Heap heap = new Heap(10);
		
		heap.insert(5);
		heap.insert(10);
		heap.insert(7);
		heap.insert(8);
		heap.insert(6);
		heap.insert(4);
		heap.insert(3);
		heap.insert(11);
		heap.insert(12);
		heap.insert(2);
		heap.insert(0);
		
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		*/
		HeapSort heapSort = new HeapSort(5);
		heapSort.insert(4);
		heapSort.insert(2);
		heapSort.insert(1);
		heapSort.insert(5);
		heapSort.insert(3);
		heapSort.heapify();
		for(int i=heapSort.getSize()-1;i>=0;i--) {
			int result = heapSort.remove();
			heapSort.insert_at(i,result);
		}
		
		heapSort.display();
	}
	
}

class HeapSort {
	private int[] arr;
	private int cur_size;
	
	public HeapSort(int val) {
		arr = new int[val];
		cur_size = 0;
	}
	
	public void insert(int val) {
		if(isFull()) {
			System.out.println("Oops full");
			return;
		}
		arr[cur_size] = val;
		cur_size++;
	}
	
	public int remove() {
		if(isEmpty()) return -1;
		int result = arr[0];
		arr[0] = arr[--cur_size];
		tickleDown(0);
		return result;
	}
	
	public boolean isFull() {
		return cur_size==arr.length;
	}
	
	public boolean isEmpty() {
		return cur_size==0;
	}
	public void tickleDown(int index) {
		int val = arr[index];
		while(index<(cur_size/2)) {
			int lchild = (2*index+1);
			int rchild = (2*index+2);
			int larger;
			if(rchild<arr.length && arr[lchild]>arr[rchild]) 
				larger = lchild;
			else 
				larger = rchild;
			if(arr[larger]<val) 
				break;
			arr[index] = arr[larger];
			index = larger;
		}
		arr[index] = val;
	}
	
	public void insert_at(int index, int val) {
		if(index<0 || index>=arr.length)
			return;
		arr[index] = val;
	}
	
	public void heapify() {
		for(int i=(cur_size-1)/2;i>=0;i--) 
			tickleDown(i);
	}
	public int getSize(){
		return cur_size;
	}
	
	public void display() {
		for(int i=0;i<arr.length;i++) 
			System.out.print(arr[i]+" ");
	}
	
}

class KLargest {
	private int[] arr;
	private int cur_size;
	private int k_size;
	private int total_size;
	
	public KLargest(int n, int k) {
		cur_size = 0;
		arr = new int[n];
		k_size = k;
		total_size = n;
	}
	
	public void heapify() {
		for(int i=(k_size-1)/2;i>=0;i--)
			tickleDown(i);
	}
	
	private void tickleDown(int index) {
		int val = arr[index];
		while(index<k_size/2) {
			int lchild = 2*index+1;
			int rchild = 2*index+2;
			int smaller;
			if(rchild<k_size && arr[lchild]<arr[rchild]) 
				smaller = lchild;
			else 
				smaller = rchild;
			if(arr[smaller]>val)
				break;
			arr[index] = arr[smaller];
			index = smaller;
		}
		arr[index]=val;
	}
	
	public int remove() {
		if(isEmpty()) return -1;
		int result = arr[0];
		arr[0] = arr[arr.length-1];
		return result;
	}
	
	public boolean isEmpty() {
		return arr.length==0;
	}
	
}
