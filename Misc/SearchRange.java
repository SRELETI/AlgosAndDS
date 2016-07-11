import java.util.Arrays;


public class SearchRange {

	private int[] searchRange(int[] A, int target) {
		int[] result = {-1,-1};
		if(A.length==0)
			return result;
		int first = searchFirst(A,target,0,A.length-1);
		int second = searchLast(A,target,0,A.length-1);
		result[0] = first;
		result[1] = second;
		return result;
	}
	
	private int searchFirst(int[] A, int target, int left, int right) {
		if(left>right)
			return -1;
		int mid = (left+right)>>1;
		if((mid==0 || (mid>left && A[mid-1]!=target)) && A[mid]==target)
			return mid;
		else if(mid+1<=right && A[mid]!=target && A[mid+1]==target)
			return mid+1;
		else if(A[mid]>target)
			return searchFirst(A,target,left,mid-1);
		else 
			return searchFirst(A,target,mid+1,right);
	}
	
	private int searchLast(int[] A, int target, int left, int right) {
		if(left>right)
			return -1;
		int mid = (left+right)>>1;
		if(mid>left && A[mid-1]==target && A[mid]!=target)
			return mid-1;
		else if((mid==right || (mid<right && A[mid+1]!=target))  && A[mid]==target)
			return mid;
		else if(A[mid]<=target)
			return searchLast(A,target,mid+1,right);
		else 
			return searchLast(A,target,left,mid-1);
	}
	
	public static void main(String args[]) {
		SearchRange s = new SearchRange();
		int[] arr = {2,2};
		int[] result = s.searchRange(arr, 2);
		System.out.println(Arrays.toString(result));
	}
	
}
