import java.util.Arrays;


public class MaxSubMatrix {

	public void subMatrix(int[][] mat) {
		if(mat.length==0) 
			return;
		int[][] result = new int[mat.length][mat[0].length];
		
		for(int i=1;i<mat.length;i++) {
			for(int j=1;j<mat[i].length;j++) {
				result[i][j] = Math.min(result[i-1][j], Math.min(result[i][j-1],result[i-1][j-1]))+mat[i][j];
			}
		}
	//	System.out.println(Arrays.deepToString(result));
		int max = 0;
		int max_i=0;
		int max_j =0;
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				if(result[i][j]>max) {
					max = result[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		System.out.println(max);
		for(int i=max_i;i>max_i-max;i--) {
			for(int j=max_j;j>max_j-max;j--) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void main(String args[]) {
		MaxSubMatrix m = new MaxSubMatrix();
	//	int[][] mat = {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		int[][] mat = {{1,2,3,4,5,6,7,8,9,0},{11,12,13,14,15,16,17,18,19,10},{21,22,23,24,25,26,27,28,29,20}};
	//	m.subMatrix(mat);
		m.printNow(mat);
	}
	
	
	public void printNow(int[][] mat) {
		if(mat.length==0)
			return;
		int row = mat.length;
		int col = mat[0].length;
		int total = row+col-1;
		for(int line =1;line<=total;line++) {
			int start_col = Math.max(0, line-row);
			int count = Math.min(line, Math.min(row,col-start_col));
			for(int i=0;i<count;i++) {
				System.out.print(mat[Math.min(line, row)-i-1][start_col+i]+" ");
			}
			System.out.println();
		}
	}
}
