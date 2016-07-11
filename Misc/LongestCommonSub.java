
public class LongestCommonSub {

	public int longestSeq(String text1, String text2) {
		if(text1.length()==0 || text2.length()==0) 
			return 0;
		int[][] lcs = new int[text1.length()+1][text2.length()+1];
		int result = 0;
		int result_i = 0;
		int result_j = 0;
		for(int i=0;i<text1.length();i++) {
			for(int j=0;j<text2.length();j++) {
				if(i==0 || j==0) 
					lcs[i][j]=0;
				else if(text1.charAt(i-1)==text2.charAt(j-1))
				{
					lcs[i][j] = lcs[i-1][j-1]+1;
					if(result<lcs[i][j]) {
						result = lcs[i][j];
						result_i = i;
						result_j= j;
					}
				}
				else
					lcs[i][j] = 0;
			}
		}
		System.out.println("The longest common substring is "+text1.substring(result_i-result,result_i));
		return result;
	}
	
	public static void main(String args[]) {
		LongestCommonSub l  = new LongestCommonSub();
		String text1 = "GeeksforGeeks.org";
		String text2 = "GeeksQuiz.com";
		l.longestSeq(text1, text2);
	}
}
