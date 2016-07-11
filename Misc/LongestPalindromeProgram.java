import java.util.Arrays;


public class LongestPalindromeProgram {

	private void maxLength(String test) {
		if(test.length()==0)
			return;
		boolean result[][] = new boolean[test.length()][test.length()];
		for(int i=0;i<test.length();i++) {
			result[i][i] = true;
		}
		int maxLength = 1;
		int start = 0;
		
		for(int i=0;i<test.length()-1;i++) {
			if(test.charAt(i)==test.charAt(i+1)) {
				result[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}
		
		for(int k=3;k<=test.length();k++) {
			for(int i=0;i<=test.length()-k;i++) {
				int end = i+k-1;
				if(result[i+1][end-1]==true && test.charAt(i)==test.charAt(end)) {
					result[i][end] = true;
					if(k>maxLength) {
						maxLength= k;
						start = i;
					}
				}
			}
		}
		
		System.out.println("THe start value is "+start+" and maxLength is "+maxLength);
		System.out.println("The longest palindrome string is "+ test.substring(start,start+maxLength));
	}
	
	
	public void maxLengthSecond(String test) {
		if(test.length()==0)
			return;
		int maxLength = 1;
		int start = 0;
		int low;
		int high;
		for(int i=1;i<test.length()-1;i++) {
			low = i-1;
			high = i;
			while(low>=0 && high<test.length() && test.charAt(low)==test.charAt(high)) {
				if(high-low+1>maxLength) {
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
			
			low = i-1;
			high = i+1;
			while(low>=0 && high <test.length() && test.charAt(low)==test.charAt(high)) {
				if(high-low+1>maxLength) {
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
		}
		
		System.out.println("The start index is "+start+" and maxLength is "+maxLength);
		System.out.println("The substring is "+test.substring(start, start+maxLength));
	}
	public static void main(String args[]) {
		LongestPalindromeProgram l = new LongestPalindromeProgram();
		l.maxLength("babcbabcbaccba");
		l.palindrome("babcbabcbaccba");
		l.palindrome("abaaba");
		l.palindrome("abababa");
		l.palindrome("abcbabcbabcba");
		l.palindrome("forgeeksskeegfor");
		l.palindrome("caba");
		l.palindrome("abacdfgdcabba");
		l.palindrome("abacdedcaba");
	}
	
	public String preprocess(String test) {
		StringBuilder sb = new StringBuilder("^");
		for(int i=0;i<test.length();i++) {
			sb = sb.append("#"+test.charAt(i));
		}
		sb = sb.append("#$");
		return sb.toString();
	}
	
	public void palindrome(String test) {
		if(test.length()==0)
			return;
		String T = preprocess(test);
		int length = T.length();
		int[] P = new int[length];
		int C=0;
		int R=0;
		int mirror;
		for(int i=1;i<length-1;i++) {
			mirror = 2*C-i;
			P[i] = R>i ? Math.min(R-i, P[mirror]) : 0;
			while(T.charAt(i+P[i]+1)==T.charAt(i-P[i]-1))
				P[i]++;
			if(i+P[i]>R) {
				C= i;
				R=i+P[i];
			}
		}
		int maxLen = 0;
		int curIndex = 0;
		for(int i=0;i<length-1;i++) {
			if(P[i]>maxLen) {
				maxLen = P[i];
				curIndex = i;
			}
		}
	//	System.out.println(Arrays.toString(P));
	//	System.out.println(test);
	//	System.out.println(maxLen+" "+curIndex);
		System.out.println(test.substring((curIndex-1-maxLen)/2, ((curIndex-1-maxLen)/2)+maxLen));
		System.out.println(test.substring((curIndex-1-maxLen)/2, (curIndex-1+maxLen)/2));
	}
}
