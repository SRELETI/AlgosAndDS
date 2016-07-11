
public class LongestThickestPal {

	private void palindrome(char[] str) {
		if(str.length<=1)
			return;
		boolean[][] temp = new boolean[str.length][str.length];
		int i=0;
		int maxLength=1;
		int maxIndex = i;
		for(i=0;i<str.length;i++) 
			temp[i][i] =true;
		for(i=0;i<str.length-1;i++) {
			if(str[i]==str[i+1])
			{
				temp[i][i+1] = true;
				maxLength = 2;
				maxIndex=i;
			}
		}
		
		for(int L=3;L<=str.length;L++) {
			for(i=0;i<str.length-L+1;i++) {
				int j = i+L-1;
				if(str[i]==str[j] && temp[i+1][j-1]==true) {
					temp[i][j] = true;
					if(j-i+1>maxLength) {
						maxLength = j-i+1;
						maxIndex = i;
					}
				}
			}
		}
		System.out.println(" The longest palindrome length is "+maxLength);
		for(int p=maxIndex;p<=maxIndex+maxLength-1;p++) {
			System.out.print(str[p]+" ");
		}
	}
	
	public static void main(String args[]) {
		LongestThickestPal l = new LongestThickestPal();
		char[] temp = {'f','o','r','g','e','e','k','s','s','k','e','e','g','f','o','r'};
		l.palindrome(temp);
	}
}
