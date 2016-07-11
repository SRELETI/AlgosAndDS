
public class SortedPrint {

	public void print(int[] arr, int start, int end) {
		if(start>end) 
			return;
		print(arr,start*2+1,end);
		System.out.print(arr[start]+" ");
		print(arr,start*2+2,end);
	}
	
	public static void main(String args[]) {
		SortedPrint s = new SortedPrint();
		int[] arr = {4,2,5,1,3};
		s.print(arr,0,arr.length-1);
	}
}
