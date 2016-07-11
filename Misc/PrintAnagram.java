import java.util.Arrays;
import java.util.Comparator;

class DupArray {
	public int index;
	public String text; 
	public DupArray(String text,int index) {
		this.text = text;
		this.index = index;
	}
}
public class PrintAnagram {
	
	public static void main(String args[]) {
		String[] text = {"cat", "dog", "tac", "god", "act"};
		PrintAnagram p = new PrintAnagram();
		p.printAna(text);
	}
	public void printAna(String[] arr) {
		if(arr.length==0)
			return;
		DupArray[] dp = new DupArray[arr.length];
		for(int i=0;i<dp.length;i++) 
			dp[i] = new DupArray("",0);
		for(int i=0;i<arr.length;i++) {
			dp[i].index = i;
			dp[i].text = arr[i];
		}
		
		for(int i=0;i<dp.length;i++) {
			StringBuilder sb = new StringBuilder(dp[i].text);
			sortString(sb,0,sb.length()-1);
			dp[i].text = sb.toString();
		}
		
		Arrays.sort(dp, new Comparator<DupArray>() {
		public int compare(DupArray t1, DupArray t2) {
			return t1.text.compareTo(t2.text);
			}
		}
		);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[dp[i].index]+" ");
		}
	}
	
	private void sortString(StringBuilder sb, int left, int right) {
		if(left>=right)
			return;
		int par = partition(sb,left,right);
		sortString(sb,left,par-1);
		sortString(sb,par+1,right);
	}
	
	private int partition(StringBuilder sb, int left, int right) {
		int index = right;
		int start = left;
		for(int i=left;i<right;i++) {
			if(sb.charAt(i)-'0'<sb.charAt(index)-'0') {
				swap(sb,start,i);
				start++;
			}
		}
		swap(sb,start,index);
		return start;
	}
	
	private void swap(StringBuilder sb, int left, int right) {
		char temp = sb.charAt(left);
		sb.setCharAt(left, sb.charAt(right));
		sb.setCharAt(right, temp);
	}
}
