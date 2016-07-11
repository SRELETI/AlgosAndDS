
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class Inversions {

	public static void main(String args[]) {
		int[] arr = {2, 3, 8, 6, 1};
		int[] temp = new int[arr.length];
	//	System.out.println(inversionCount(arr,temp,0,arr.length-1));
		System.out.println(inversionCount_Simple(arr));
	}
	
	public static int inversionCount_Simple(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		int inv_count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) 
					inv_count++;
			}
		}
		return inv_count;
	}
	
	public static int inversionCount(int[] arr,int[] temp, int left, int right) {
		if(arr == null || arr.length<=1) return 0;
		int count = 0;
		if(right>left) {
			int mid = (right+left)/2;
			count = inversionCount(arr,temp,left,mid);
			count  += inversionCount(arr,temp,mid+1,right);
			count += mergeInversion(arr,temp,left,mid+1,right);
		}
		return count;
	}
	
	private static int mergeInversion(int[]arr, int[] temp, int start, int mid, int end) { 
		int i = start;
		int j = mid;
		int k = start;
		int count = 0;
		while(i<= mid-1 && j<=end) {
			if(arr[i]<=arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
				count += mid-i;
			}
		}
		while(i<=mid-1) {
			temp[k++] = arr[i++];
		}
		while(j<=end) {
			temp[k++] = arr[j++];
		}
		
		for(int p=start;p<=end;p++) {
			arr[p] = temp[p];
		}
		return count;
	}
}
