
public class MinHeapKSorted {

	private HeapNode[] arr;
	private int maxSize;
	private int curSize;
	
	public MinHeapKSorted(int length) {
		arr = new HeapNode[length];
		maxSize = length;
		curSize = 0;
	}
	
	public void insert(int val,int cur, int next) {
		if(isFull()) 
			return;
		HeapNode newNode = new HeapNode(val,cur,next);
		arr[curSize] =newNode;
		heapUp(curSize++);
	}
	
	public HeapNode delete() {
		if(isEmpty()) 
			return null;
		HeapNode temp = arr[0];
		arr[0] = arr[--curSize];
		heapDown(0);
		return temp;
	}
	
	public boolean isFull() {
		return curSize==maxSize;
	}
	
	public boolean isEmpty() {
		return curSize==0;
	}
	
	public void heapDown(int index) {
		HeapNode temp = arr[index];
		int pointer;
		while(index<curSize/2) {
			int left = 2*index+1;
			int right = 2*index+2;
			if(right<curSize && arr[left].data>arr[right].data) 
				pointer = right;
			else
				pointer = left;
			if(temp.data>arr[pointer].data) {
				arr[index] = arr[pointer];
				index = pointer;
			}
			else
				break;
		}
		arr[index] =temp;
	}
	
	public void heapUp(int index) {
		
		HeapNode temp = arr[index];
		while(index>0) {
			int parent = (index-1)/2;
			if(arr[parent].data>temp.data) {
				arr[index] = arr[parent];
				index = parent;
			}
			else
				break;
		}
		arr[index] = temp;
	}
	
	public static void main(String args[]) {
		MinHeapKSorted m = new MinHeapKSorted(10);
	//	for(int i=0;i<10;i++) 
	//		m.insert(10-i);
		int[][] mat = { {10, 11, 12},
				{7, 8, 9},
				{4, 5, 6},
                {1, 2, 3},
              };
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0;i<row;i++) {
			m.insert(mat[i][0], i, 1);
		}
		for(int count = 0;count<row*col;count++) {
			HeapNode  del = m.delete();
			System.out.print(del.data+" ");
			if(del.nextI<col) {
				m.insert(mat[del.i][del.nextI], del.i, del.nextI+1);
			}
			else
				m.insert(Integer.MAX_VALUE, del.i, del.nextI);
		}
		
		
	}
}
