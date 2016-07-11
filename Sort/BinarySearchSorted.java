
public class BinarySearchSorted {

	public int sorted(int[] arr, int left, int right, int element)
	{
		if(right<left)
			return -1;
		int middle = (left+right)>>1;
		if(arr[middle]==element)
			return middle;
		if(middle>left && arr[middle-1]==element)
			return middle-1;
		if(middle<right && arr[middle+1]==element)
			return middle+1;
		if(arr[middle]<element)
			return sorted(arr,middle+2,right,element);
		else
			return sorted(arr,left,middle-2,element);
	}
	
	public static void main(String args[])
	{
		int[] arr = {10, 3, 40, 20, 50, 80, 70};
		BinarySearchSorted b = new BinarySearchSorted();
		System.out.println(b.sorted(arr, 0, 6, 90));
		
	}
}
