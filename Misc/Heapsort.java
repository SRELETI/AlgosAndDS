import java.util.Arrays;


public class Heapsort {
	public void build_heap(int arr[])
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
		{
			max_heapify(arr,i,n);
		}
	}
	public void max_heapify(int arr[],int index,int length)
	{
		int largest=index;
		int left=2*index+1;
		int right=2*index+2;
		if(left<length && arr[largest]<arr[left])
		{
			largest=left;
		}
		if(right<length && arr[largest]<arr[right])
		{
			largest=right;
		}
		if(largest!=index)
		{
			int temp=arr[largest];
			arr[largest]=arr[index];
			arr[index]=temp;
			max_heapify(arr,largest,length);
		}
	}
	public void heapsort(int arr[])
	{
		build_heap(arr);
		int length=arr.length;
		for(int n=length-1;n>=1;n--)
		{
			int temp=arr[n];
			arr[n]=arr[0];
			arr[0]=temp;
			length--;
			max_heapify(arr,0,length);
		}
	}
	public static void main(String args[])
	{
		int arr[]={5,13,2,25,7,17,20,8,4};
		Heapsort hs=new Heapsort();
		hs.heapsort(arr);
		System.out.print(Arrays.toString(arr));
	}
}
