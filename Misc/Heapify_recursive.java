import java.util.Arrays;


public class Heapify_recursive {
	public void heapify(int arr[],int index)
	{
		
		while(index <=arr.length)
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
			}
			if(largest_index==index)
				return;
		}
	}
	public static void main(String args[])
	{
		int arr[]={7,5,2,3,1,4};
		Max_Heapify mh=new Max_Heapify();
		mh.heapify(arr, 4);
		//mh.min_heapify(arr,0);
		System.out.println(Arrays.toString(arr));
	}
}
