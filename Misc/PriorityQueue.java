import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue
{
	public int max_priority(ArrayList<Integer> arr)
	{
		return arr.get(0);
	}
	public int Extract_max_priority(ArrayList<Integer> arr)
	{
		int max=arr.get(0);
		Collections.swap(arr, 0, arr.size()-1);
		arr.remove(arr.size()-1);
		max_heapify(arr,0,arr.size());
		return max;
	}
	public void increase_key(ArrayList<Integer> arr, int index, int key)
	{
		if(key<arr.get(index))
			return;
		arr.set(index,key);
		while(index>0 && arr.get(index)>arr.get((index-1)/2))
		{
			Collections.swap(arr,index,(index-1)/2);
			index=(index-1)/2;
		}
	}
	public void insert(ArrayList<Integer> arr, int element)
	{
		arr.add(Integer.MIN_VALUE);
		increase_key(arr,arr.size()-1,element);
	}
	public void max_heapify(ArrayList<Integer> arr, int index, int length)
	{
		int largest=index;
		int left=2*index+1;
		int right=2*index+2;
		if(left<length && arr.get(left)>arr.get(largest))
			largest=left;
		if(right<length && arr.get(right)>arr.get(largest))
			largest=right;
		if(largest!=index)
		{
			Collections.swap(arr,largest,index);
			max_heapify(arr,largest,length);
		}
	}
	public static void main(String args[])
	{
		ArrayList<Integer> arr= new ArrayList<Integer>();
		PriorityQueue pq=new PriorityQueue();
		pq.insert(arr,5);
		pq.insert(arr, 10);
		pq.insert(arr, 2);
		pq.insert(arr, 12);
		System.out.println("The priority queue " +arr.toString());
		System.out.println("The max element in priority queue " +pq.max_priority(arr));
		pq.increase_key(arr, 3, 22);
		System.out.println("The max element after increasing key " +pq.max_priority(arr));
		System.out.println("The priority queue now "+arr.toString());
		System.out.println("The max element removed " + pq.Extract_max_priority(arr));
		System.out.println("the Priority Queue after removing an element " +arr.toString());
		System.out.println("The max element now " +pq.max_priority(arr));
	}
}
