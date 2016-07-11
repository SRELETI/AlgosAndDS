import java.util.Arrays;


public class Shuffle {

	public static void main(String args[]) {
		Shuffle s = new Shuffle();
		int[] arr = new int[52];
		for(int i=1;i<=52;i++) {
			arr[i-1] = i;
		}
		s.shuffle(arr);
	}
	
	public void shuffle(int[] arr) {
		if(arr==null || arr.length==0)
			return;
		int i = arr.length-1;
		System.out.println(Arrays.toString(arr));
		while(i>0) {
			double temp =  Math.random();
			int temp2 = (int) (temp*i);
			swap(arr,temp2,i);
			i--;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
