
public class PrintSortedAgain {

	public void printNow(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0;i<row*col;i++) {
			System.out.print(extractMin(mat)+" ");
		}
	}
	
	private int extractMin(int[][] mat) {
		int re = mat[0][0];
		mat[0][0] = Integer.MAX_VALUE;
		youngify(mat,0,0);
		return re;
	}
	
	private void youngify(int[][] mat, int i, int j) {
		int down = i+1<mat.length ? mat[i+1][j] : Integer.MAX_VALUE;
		int right = j+1<mat[i].length ? mat[i][j+1] : Integer.MAX_VALUE;
		
		if(down==Integer.MAX_VALUE && right == Integer.MAX_VALUE) 
			return;
		if(down<right) {
			mat[i][j] = down;
			mat[i+1][j] = Integer.MAX_VALUE;
			youngify(mat,i+1,j);
		}
		else
		{
			mat[i][j] = right;
			mat[i][j+1] = Integer.MAX_VALUE;
			youngify(mat,i,j+1);
		}
	}
	
	public static void main(String args[]) {
		PrintSortedAgain p = new PrintSortedAgain();
		int[][] mat = {{10,20,30}};
		p.printNow(mat);
	}
}
