
public class PivotFind {

	public int find(int[] arr, int left, int right) {
		if(left>right)
			return -1;
		int middle = (left+right)>>1;
		if(middle>left && arr[middle]<arr[middle-1])
			return middle;
		else if(middle+1<=right && arr[middle+1]<arr[middle])
			return middle+1;
		else if(arr[middle]>arr[right])
			return find(arr,middle+1,right);
		else
			return find(arr,left,middle-1);
	}
	
	
	public static void main(String args[]) {
		PivotFind p = new PivotFind();
		int[] ar = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
		int no = 0;
		int pivot = p.find(ar, 0, ar.length-1);
	//	System.out.println(pivot);
		int index = p.findElement(ar,pivot,no);
		System.out.println(index);
	}
	
	private int findElement(int[] ar, int pivot, int element) {
		if(pivot==-1)
			return findAr(ar,element,0,ar.length-1);
		else if(ar[pivot]==element)
			return pivot;
		else if(element>=ar[0])
			return findAr(ar,element,0,pivot-1);
		else
			return findAr(ar,element,pivot+1,ar.length-1);
	}
	
	private int findAr(int[] arr, int element, int left,int right) {
		if(left>right)
			return -1;
		int middle = (left+right)>>1;
		if(arr[middle]==element)
			return middle;
		else if(element<arr[middle])
			return findAr(arr,element,left,middle-1);
		else 
			return findAr(arr,element,middle+1,right);
	}
}
