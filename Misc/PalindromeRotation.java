
public class PalindromeRotation {

	public boolean rotation(String text) {
		if(text.length()==0)
			return true;
		if(isPalindrome(text))
			return true;
		for(int i=0;i<text.length()-1;i++) {
			String temp = rotate(text,i);
			if(isPalindrome(temp))
				return true;
		}
		return false;
	}
	
	public String rotate(String text, int index) {
		StringBuilder sb = new StringBuilder(text);
		reverse(sb,0,index);
		reverse(sb,index+1,sb.length()-1);
		reverse(sb,0,sb.length()-1);
		return sb.toString();
	}
	
	public void reverse(StringBuilder sb, int i, int j) {
		while(i<j) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
	}
	public boolean isPalindrome(String text) {
		if(text.length()==0)
			return true;
		int left =0;
		int right = text.length()-1;
		while(left<right) {
			if(text.charAt(left)!=text.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String args[]) {
		PalindromeRotation p = new PalindromeRotation();
		String text = "abcd";
	//	System.out.println(p.rotation(text));
		System.out.println(p.second_palin(text));
	}
	
	public boolean second_palin(String text) {
		if(text.length()==0)
			return true;
	//	if(isPalindrome(text))
		//	return true;
		String temp = text+text;
		return lps(temp, text.length());
	}
	
	public boolean lps(String temp, int n) {
		boolean[][] res = new boolean[temp.length()][temp.length()];
		for(int i=0;i<temp.length();i++) {
			res[i][i] = true;
		}
		int maxLength = 0;
		int maxIndex = 0;
		for(int i=0;i<temp.length()-1;i++) {
			if(temp.charAt(i)==temp.charAt(i+1)) {
				maxLength = 2;
				maxIndex=i;
				res[i][i+1]=true;
			}
		}
		
		for(int l=3;l<=temp.length();l++) {
			for(int i=0;i<=temp.length()-l;i++) {
				int j = i+l-1;
				if(temp.charAt(i)==temp.charAt(j) && res[i+1][j-1]==true) {
					res[i][j] = true;
					if(maxLength<j-i+1 && j-i+1<=n) {
						maxLength = j-i+1;
						maxIndex = j;
					}
				}
			}
		}
	//	System.out.println(maxLength);
		return maxLength == n;
	}
} 
