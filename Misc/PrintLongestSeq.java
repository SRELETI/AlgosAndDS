import java.util.Arrays;


public class PrintLongestSeq {

	public void longest(String text1, String text2) {
		if(text1.length()==0 || text2.length()==0)
			return;
		int[][] result = new int[text1.length()+1][text2.length()+1];
		for(int i=0;i<result.length;i++)  {
			for(int j=0;j<result[i].length;j++) {
				if(i==0 || j==0)
					result[i][j] = 0;
				else if(text1.charAt(i-1)==text2.charAt(j-1)) 
					result[i][j] = 1+result[i-1][j-1];
				else
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
			}
		}
	//	System.out.println(result[text1.length()][text2.length()]);
		char[] arr = new char[result[text1.length()][text2.length()]];
		int i=text1.length();
		int j = text2.length();
		int index = result[text1.length()][text2.length()];
		while(i>0 && j>0) {
			if(text1.charAt(i-1)==text2.charAt(j-1)) {
				arr[index-1] = text1.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(result[i-1][j]>result[j-1][i])
				i--;
			else
				j--;
				
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[]) {
		PrintLongestSeq p = new PrintLongestSeq();
		p.longest("ABCDGH", "AEDFHR");
		
	}
}
