
public class Lexicographic {

	public int rank(String text) {
		if(text.length()==0)
			return 0;
		int n = text.length();
		int fact = factorial(n);
		int rank = 1;
		for(int i=0;i<n;i++) {
			fact = fact/(n-i);
			int count = findRightSmall(text,i);
			rank += count*fact;
		}
		return rank;
	}
	
	private int findRightSmall(String text, int i) {
		int count = 0;
		for(int k=i+1;k<text.length();k++) {
			if(text.charAt(k)<text.charAt(i))
				count++;
		}
		return count;
	}
	
	private int factorial(int n) {
		int k=1;
		for(int i=1;i<=n;i++) 
			k = k *i;
		return k;
	}
	
	public static void main(String args[]){
		Lexicographic l = new Lexicographic();
		String text = "STRING";
		System.out.println(l.rank(text));
		System.out.println(l.opt_lexi(text));
	}
	
	public int opt_lexi(String text) {
		if(text.length()==0)
			return 0;
		int fact = factorial(text.length());
		int rank = 1;
		int[] count = new int[256];
		populate(text,count);
		for(int i=0;i<text.length();i++) {
			fact = fact/(text.length()-i);
			int val = count[((int)text.charAt(i))-1];
			rank +=(val*fact);
			updateCount(count,text.charAt(i));
		}
		return rank;
	}
	
	private void updateCount(int[] count, char i) {
		for(int k=(int) i;k<count.length;k++) 
			count[k]--;
	}
	
	private void populate(String text, int[] count) {
		for(int i=0;i<text.length();i++) 
			count[text.charAt(i)]++;
	//	System.out.println((int)text.charAt(0));
		for(int i=1;i<count.length;i++) 
			count[i] +=count[i-1];
	//	System.out.println(count[text.charAt(0)]);
	}
}
