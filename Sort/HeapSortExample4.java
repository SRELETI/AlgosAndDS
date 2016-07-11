import java.util.Arrays;


public class HeapSortExample4 {

	public void heapify(int[] arr)
	{
		int length = arr.length;
		for(int i=length/2;i>=0;i--)
			tickleDown(arr,i,length);
	}
	
	public void tickleDown(int[] arr, int index,int length)
	{
		int largestChild;
		int lchild;
		int rchild;
		int temp = arr[index];
		while(index<length/2)
		{
			lchild = 2*index+1;
			rchild = lchild+1;
			if(rchild<length && arr[rchild]>arr[lchild])
				largestChild = rchild;
			else
				largestChild = lchild;
			if(arr[largestChild]<=temp)
				break;
			arr[index]=arr[largestChild];
			index = largestChild;
		}
		arr[index] = temp;
	}
	public int remove(int[] arr, int i)
	{
		int del = arr[0];
		arr[0] = arr[i];
		tickleDown(arr,0,i-1);
		return del;
	}
	public void insert(int[] arr, int index, int val)
	{
		arr[index]=val;
	}
	public static void main(String args[])
	{
		int[] arr = {12, 11, 13, 5, 6, 7};
		HeapSortExample4 h = new HeapSortExample4();
		System.out.println(Arrays.toString(arr));
		h.heapify(arr);
		
		for(int i=arr.length-1;i>=0;i--)
		{
			int del = h.remove(arr, i);
			h.insert(arr,i,del);
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
