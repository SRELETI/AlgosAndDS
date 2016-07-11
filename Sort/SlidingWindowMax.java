import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class SlidingWindowMax {

	public void find(int[] arr, int[] result, int w) {
		if(arr.length==0 || arr.length<w) 
			return;
		Deque<Integer> d  = new LinkedList<Integer>();
		for(int i=0;i<w;i++) {
			while(!d.isEmpty() && arr[i]>=arr[d.peekLast()]) 
				d.pollLast();
			d.addLast(i);
		}
		
		for(int i=w;i<arr.length;i++) {
			result[i-w] = arr[d.peekFirst()];
			while(!d.isEmpty() && arr[i]>=arr[d.peekLast()]) 
				d.pollLast();
			while(!d.isEmpty() && arr[d.peekFirst()]<=i-w) 
				d.pollFirst();
			d.addLast(i);
		}
		result[arr.length-w] = d.peekFirst();
	}
	
	public static void main(String args[]) {
		SlidingWindowMax s = new SlidingWindowMax();
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int w = 3;
		int[] result = new int[arr.length-w+1];
		s.find(arr, result, w);
		System.out.println(Arrays.toString(result));
	}
}
