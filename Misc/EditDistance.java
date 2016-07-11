import java.util.Arrays;


public class EditDistance {


	 public int minDistance(String word1, String word2) {
	       int[][] result = new int[word1.length()+1][word2.length()+1];
	       for(int i=0;i<=word1.length();i++) {
	           result[i][0] = i;
	       }
	       for(int j=0;j<=word2.length();j++) {
	           result[0][j] = j;
	       }
	       
	       for(int i=1;i<=word1.length();i++) {
	           for(int j=1;j<=word2.length();j++) {
	               result[i][j] = Math.min(result[i-1][j]+1,Math.min(result[i][j-1]+1, (result[i-1][j-1] + (word1.charAt(i-1)!=word2.charAt(j-1)==true ? 1:0))));
	           }
	       }
	       System.out.println(Arrays.deepToString(result));
	       return result[word1.length()][word2.length()];
	    }
	 
	 public static void main(String args[]) {
		 EditDistance e = new EditDistance();
		 System.out.println(e.minDistance("a", "ab"));
	 }
    }


