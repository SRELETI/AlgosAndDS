import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RotationsOrNot {

	public boolean isRotation(String s1, String s2) {
		String temp = s1+s1;
		if(temp.contains(s2))
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		RotationsOrNot r = new RotationsOrNot();
	//	System.out.println(r.isRotation("ABCD", "ACBD"));
	//	r.printString("ABCD", 0);
		char[] ch = {'1','1','2'};
	//	r.permutate(ch, 0, ch.length-1);
	//	r.nowPermutate(ch);
		r.permutationSeq(4, 10);
	}
	
	public void printString(String s, int index) {
		if(index>=s.length())
			return;
		printString(s,index+1);
		System.out.print(s.charAt(index)+" ");
	}
	
	public void permutate(char[] s, int start, int end) {
		if(start==end) {
			System.out.println(s);
			return;
		}
		for(int i=start;i<=end;i++) {
			swap(s,i,start);
			permutate(s,start+1,end);
			swap(s,i,start);
		}
	}
	
	private void swap(char[] s, int start, int end) {
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
	}
	private boolean[] arr;
	private List<Character> l;
	private void nowPermutate(char[] ch) {
		arr = new boolean[ch.length];
		l = new ArrayList<Character>();
		Arrays.sort(ch);
		permutateUnique(ch);
	}
	private void permutateUnique(char[] ch) { 
		if(l.size()==ch.length) {
			System.out.println(l.toString());
			return;
		}
		
		for(int i=0;i<ch.length;i++) {
			if(arr[i]==true)
				continue;
			if(i>0 && ch[i]==ch[i-1] && arr[i-1]==false)
				continue;
			arr[i] = true;
			l.add(ch[i]);
			permutateUnique(ch);
			l.remove(l.size()-1);
			arr[i]= false;
		}
	}
	
	
	public void permutationSeq(int n, int k) {
		int[] arr = new int[n];
		int fact = 1;
		for(int i=0;i<n;i++) {
			fact = fact*(i+1);
			arr[i]= i+1;
		}
		StringBuilder sb = new StringBuilder();
		getper(arr,fact,n,k,sb );
		System.out.println(sb.toString());
	}
	
	private void getper(int[] arr, int fact, int n, int k, StringBuilder sb) {
		if(n==1) {
			sb.append(arr[0]);
			return;
		}
		
		fact = fact/n;
		int j= (k-1)/fact;
		sb.append(arr[j]);
		while(j<n-1) {
			arr[j++] = arr[j];
		}
		getper(arr,fact,n-1,((k-1)%fact)+1,sb);
	}
}
