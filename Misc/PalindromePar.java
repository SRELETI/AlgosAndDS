
public class PalindromePar {

	public int palindrome(String text) {
		if(text.length()<=1) {
			return 0;
		}
		int len = text.length();
		int[][] C = new int[len][len];
		boolean[][] P = new boolean[len][len];
		
		for(int i=0;i<len;i++) {
			P[i][i] = true;
			C[i][i] = 0;
		}
		
		for(int L=2;L<=len;L++) {
			for(int i=0;i<len-L+1;i++) {
				int j = i+L-1;
				
				if(L==2) {
					P[i][j] = (text.charAt(i)==text.charAt(j));
				}
				else
					P[i][j] = (text.charAt(i)==text.charAt(j) && P[i+1][j-1]==true);
				
				if(P[i][j]==true) {
					C[i][j] = 0;
				}
				else
				{
					C[i][j] = Integer.MAX_VALUE;
					for(int k=i;k<=j-1;k++){
						C[i][j] = Math.min(C[i][j], C[i][k]+C[k+1][j]+1);
					}
				}
			}
			
		}
		return C[0][len-1];
	}
	
	public static void main(String args[]) {
		PalindromePar p = new PalindromePar();
		String text = "ababbbabbababa";
		System.out.println(p.palindrome(text));
		System.out.println(p.opt_part(text));
	}
	
	
	public int opt_part(String text) {
		if(text.length()<=1)
			return 0;
		int n = text.length();
		boolean[][] P = new boolean[n][n];
		
		int[] C = new int[n];
		
		for(int i=0;i<n;i++) {
			P[i][i] = true;
		}
		
		for(int L=2;L<=n;L++) {
			for(int i=0;i<n-L+1;i++) {
				int j = i+L-1;
				if(L==2) {
					P[i][j] = (text.charAt(i)==text.charAt(j));
				}
				else
					P[i][j] = ((text.charAt(i)==text.charAt(j)) && P[i+1][j-1]==true);
			}
		}
		
		for(int i=0;i<n;i++) {
			if(P[0][i]==true) {
				C[i]=0;
			}
			else
			{
				C[i]=Integer.MAX_VALUE;
				for(int j=0;j<i;j++) {
					if(P[j+1][i]==true && 1+C[j]<C[i])
						C[i]= 1+C[j];
				}
			}
		}
		return C[n-1];
	}
	
}
