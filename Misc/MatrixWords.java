
public class MatrixWords {

	public void find(char[][] mat, String words) {
		if(mat.length==0)
			return;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				findNow(i,j,0,"",mat,words);
			}
		}
	}
	
	private void findNow(int i, int j, int index, String pos, char[][] mat, String words) {
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length)
			return;
		if(mat[i][j]!=words.charAt(index))
			return;
		pos = pos+words.charAt(index)+" ["+i+","+j+"]";
		if(index<words.length()-1) {
			findNow(i-1,j-1,index+1,pos,mat,words);
			findNow(i-1,j,index+1,pos,mat,words);
			findNow(i-1,j+1,index+1,pos,mat,words);
			findNow(i,j-1,index+1,pos,mat,words);
			findNow(i,j+1,index+1,pos,mat,words);
			findNow(i+1,j-1, index+1, pos, mat, words);
			findNow(i+1,j,index+1,pos,mat,words);
			findNow(i+1,j+1,index+1,pos,mat,words);
		}
		else
			System.out.println(pos);
	}
	
	public static void main(String args[]) {
		char[][] mat = { {'A', 'N', 'L', 'Y', 'S'},
                {'I', 'S', 'D', 'E', 'S'},
                {'I', 'G', 'N', 'D', 'E'}};
		String words = "DES";
		MatrixWords m = new MatrixWords();
		m.find(mat, words);
	}
}
