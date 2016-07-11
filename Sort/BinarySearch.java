
public class BinarySearch {

	public int binarySearch(int[] arr, int left, int right, int element) {
		if(left>right) 
			return -1;
		int middle = left+(right-left)/2;
		if(arr[middle]==element) 
			return middle;
		else if(arr[middle]>element) 
			return binarySearch(arr,left,middle-1,element);
		else 
			return binarySearch(arr,middle+1,right,element);
	}
	
	public int binarySearchIterative(int[] arr, int element) {
		if(arr.length==0 || arr==null)
			return -1;
		int left = 0;
		int right = arr.length-1;
		int middle;
		while(left<=right) {
			middle = left+(right-left)/2;
			if(arr[middle]==element)
				return middle;
			else if(arr[middle]<element) 
				left = middle+1;
			else
				right = middle-1;
		}
		return -1;
	}
	public static void main(String args[]) {
		BinarySearch search = new BinarySearch();
		int[] arr = {2, 3, 4, 10, 40};
		int element = 4;
		System.out.println(search.binarySearch(arr, 0, arr.length-1, element));
	}
}
