import java.util.Arrays;


public class Leth {

	public int findNow(String a1, String a2) {
		if(a1.length()==0) 
			return a2.length();
		if(a2.length()==0)
			return a1.length();
		int[][] result = new int[a2.length()+1][a1.length()+1];
		int val=1;
		result[0][0] = 0;
		for(int i=1;i<=a1.length();i++)
			result[0][i] = val+result[0][i-1];
		val = 1;
		for(int i=1;i<=a2.length();i++) 
			result[i][0] = val+result[i-1][0];
		for(int i=1;i<=a2.length();i++) {
			for(int j=1;j<=a1.length();j++) {
				int min = Math.min(result[i-1][j], Math.min(result[i][j-1],result[i-1][j-1]));
				if(a2.charAt(i-1)==a1.charAt(j-1))
					result[i][j] = min;
				else
					result[i][j] = min+1;
			}
		}
	//	System.out.println(Arrays.deepToString(result));
		return result[a2.length()][a1.length()];
	}
	
	public static void main(String args[]) {
		Leth l = new Leth();
	//	System.out.println(l.findNow("abcde", "abce"));
		System.out.println(3/2*1);
	}
}
