import java.util.Arrays;


public class Max_Heapify {
	public void heapify(int arr[],int index)
	{
		int largest_index=index;
		int left_child=(2*index)+1;
		int right_child=(2*index)+2;
		if(left_child<arr.length && arr[left_child]>arr[largest_index])
		{
			largest_index=left_child;
		}
		if(right_child<arr.length && arr[right_child]>arr[largest_index])
		{
			largest_index=right_child;
		}
		if(largest_index!=index)
		{
			int temp=arr[largest_index];
			arr[largest_index]=arr[index];
			arr[index]=temp;
			heapify(arr,largest_index);
		}
	}
	public void min_heapify(int arr[], int index)
	{
		int smallest=index;
		int left=2*index+1;
		int right=2*index+2;
		if(left<arr.length && arr[left]<arr[smallest])
			smallest=left;
		if(right<arr.length && arr[right]<arr[smallest])
			smallest=right;
		if(smallest != index)
		{
			int temp=arr[smallest];
			arr[smallest]=arr[index];
			arr[index]=temp;
			min_heapify(arr,smallest);
		}
	}
	public static void main(String args[])
	{
		int arr[]={7,5,2,3,1,4};
		Max_Heapify mh=new Max_Heapify();
		mh.heapify(arr, 0);
		//mh.min_heapify(arr,0);
		System.out.println(Arrays.toString(arr));
	}
}
