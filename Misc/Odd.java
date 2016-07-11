
public class Odd {

	public static int odd(int[] x) {
		// Effects: if x==null throw NullPointerException,
		// else return the number of elements in x that are odd
		int count = 0;
	for (int i =0; i < x.length; i++) {
		if (x[i]%2==1) {
		count++;
		}
	}
	return count;
	}
	
	public static void main(String args[]) {
		Odd o = new Odd();
		int[] arr ={};
	//	System.out.println(odd(arr));
		System.out.print("error\n");
	}
}
