import java.util.Arrays;

class StackSpan {
	int[] arr;
	private int count;
	private int max_count;
	
	public StackSpan(int length) {
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
		return count==max_count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public int peek() {
		if(isEmpty())
			return -1;
		return arr[count-1];
	}
	
	public void display() {
		for(int i=count-1;i>=0;i--)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}

public class StockSpan {

	private StackSpan ss;
	
	public StockSpan(int length) {
		ss = new StackSpan(length);
	}
	
	public void stock(int[] arr) {
		if(arr.length==0)
			return;
		int[] result = new int[arr.length];
		result[0] =1;
		ss.push(0);
		for(int i=1;i<arr.length;i++)
		{
			while(!ss.isEmpty() && arr[ss.peek()]<arr[i])
				ss.pop();
			result[i] = ss.isEmpty() ?  i+1 : i-ss.peek();
			ss.push(i);
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String args[]) {
		int[] arr = {10, 4, 5, 90, 120, 80};
		StockSpan s = new StockSpan(arr.length);
		s.stock(arr);
	}
}
