public class MatrixKMP {

	private void find(char[][] mat, String pat) {
		if(mat.length==0 || pat.length()==0)
			return;
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0;i<row;i++) {
			boolean answ = kmp(mat,i,col,pat,true);
			if(answ==true) {
				System.out.println("The pattern found in the row "+i);
			}
		}
		
		for(int i=0;i<col;i++) {
			boolean answ = kmp(mat,i,row,pat,false);
			if(answ==true) {
				System.out.println("The pattern found in the col " + i);
			}
		}
	}
	
	private boolean kmp(char[][] mat, int row_no, int col, String pat,boolean flag) {
		int[] lps = constructArr(pat);
		int textI = 0;
		int patI=0;
		if(flag==true)
		{
			while(textI<col) {
				if(mat[row_no][textI]==pat.charAt(patI)) {
					patI++;
					textI++;
				
					if(patI==pat.length()) {
						return true;
					}
				}
				else {
					if(patI==0) {
						textI++;
					}
					else
						patI = lps[patI-1];
				}
			}
		return false;
		}
		else
		{
			while(textI<col) {
				if(mat[textI][row_no]==pat.charAt(patI)) {
					patI++;
					textI++;
				
					if(patI==pat.length()) {
						return true;
					}
				}
				else {
					if(patI==0) {
						textI++;
					}
					else
						patI = lps[patI-1];
				}
			}
		return false;
		}
	}
	
	private int[] constructArr(String pat) {
		int[] lps = new int[pat.length()];
		lps[0]=0;
		int len = 0;  // length of previous prefix suffix array
		int i=1;
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len==0) {
					lps[i] = 0;
					i++;
				}
				else
					len = lps[len-1];
			}
		}
		return lps;
	}
	
	public static void main(String args[]) {
		MatrixKMP m = new MatrixKMP();
		char[][] mat = {{'k','u','d','e','e','p'},{'d','d','e','e','p','s'}, {'d','e','e','p','s','u'},{'e','e','p','s','u','d'},{'e','p','s','u','d','e'},{'p','u','d','e','e','p'}};
		m.find(mat, "sudeep");
	}
}
