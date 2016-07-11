import java.util.Arrays;

class HeapEx
{
	int data;
	int cur;
	int next;
	public HeapEx(int val)
	{
		data = val;
		cur =0;
		next=0;
	}
	
	public int getCur()
	{
		return cur;
	}
	public void setCur(int index)
	{
		cur = index;
	}
	public int getNext()
	{
		return next;
	}
	
	public void setNext(int index)
	{
		next = index;
	}
}
class MinHeap1
{
	HeapEx[] arr;
	int max_size;
	int cur_size;
	public MinHeap1(int val)
	{
		arr = new HeapEx[val];
		max_size = val;
		cur_size = 0;
	}
	
	public void insert(int val, int cur, int nex)
	{
		if(isFull())
		{
			System.out.println("The heap is full ");
			return;
		}
		HeapEx newNode = new HeapEx(val);
		arr[cur_size]=newNode;
		arr[cur_size].setCur(cur);
		arr[cur_size].setNext(nex);
		tickleUp(cur_size++);
	}
	
	public boolean isFull()
	{
		return cur_size == max_size;
	}
	
	public boolean isEmpty()
	{
		return cur_size == 0;
	}
	
	public HeapEx delete()
	{
		if(isEmpty())
			return null;
		HeapEx res = arr[0];
		arr[0] = arr[--cur_size];
		tickleDown(0);
		return res;
	}
	
	public void tickleUp(int index)
	{
		int parent = (index-1)/2;
		HeapEx temp = arr[index];
		while(index>0)
		{
			if(parent>=0 && arr[parent].data<=arr[index].data)
				break;
			arr[index]= arr[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		arr[index]=temp; 
	}
	
	public void tickleDown(int index)
	{
		int left;
		int right;
		HeapEx temp = arr[index];
		int largest;
		while(index<cur_size/2)
		{
			left = 2*index+1;
			right = left+1;
			if(right<cur_size && arr[right].data<arr[left].data)
				largest = right;
			else
				largest = left;
			if(temp.data<=arr[largest].data)
				break;
			arr[index]=arr[largest];
			index = largest;
		}
		arr[index] = temp;
	}
}
public class MergeKSorted {

	public void combine(int[][] arr, int k)
	{
		int n = arr[0].length;
		int[] result = new int[n*k];
		MinHeap1 hea = new MinHeap1(k);
		for(int i=0;i<k;i++)
		{
			int temp = arr[i][0];
			hea.insert(temp, i, 1);
		}
		
		for(int count=0;count<n*k;count++)
		{
			HeapEx h = hea.delete();
			result[count]=h.data;
			if(h.next<n)
			{
				hea.insert(arr[h.cur][h.next], h.cur, h.next+1);
			}
			else
				hea.insert(Integer.MAX_VALUE, 0, 0);
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String args[])
	{
		int arr[][] =  {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
		int k = arr.length;
		MergeKSorted m = new MergeKSorted();
		m.combine(arr, k);
	}
}