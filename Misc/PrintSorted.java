import java.util.Arrays;


public class PrintSorted {

	private void print(int[][] mat) {
		int length = mat.length*mat.length;
		for(int i=0;i<length;i++) {
			System.out.print(extractMin(mat)+" ");
		}
	}
	
	
	public static void main(String args[]) {
		PrintSorted p = new PrintSorted();
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		p.print(mat);
	//	System.out.println(Arrays.deepToString(mat));
	}
	private int extractMin(int[][] mat) {
		int ret = mat[0][0];
		mat[0][0] = Integer.MAX_VALUE;
		youngify(mat,0,0);
		return ret;
	}
	
	private void youngify(int[][] mat,int i,int j) {
		
		int down = i+1<mat.length ? mat[i+1][j] : Integer.MAX_VALUE;
		int right = j+1<mat.length ? mat[i][j+1] : Integer.MIN_VALUE;
		
		if(down==Integer.MAX_VALUE && right == Integer.MIN_VALUE)
			return;
		if(down<right) {
			mat[i][j] = mat[i+1][j];
			mat[i+1][j] =Integer.MAX_VALUE;
			youngify(mat,i+1,j);
		}
		else
		{
			mat[i][j] = mat[i][j+1];
			mat[i][j+1] = Integer.MAX_VALUE;
			youngify(mat,i,j+1);
		}
	}
}
