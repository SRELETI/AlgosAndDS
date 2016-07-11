
public class RotateNowNow {

	public void rotate(int[][] mat) {
		if(mat.length==0)
			return;
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0;i<row/2;i++) {
			for(int j=i;j<col-1;j++) {
				int temp = mat[i+j][col-1];
				mat[i+j][col-1] = mat[i][j];
				mat[i][j] = mat[row-1-j][i];
				mat[row-1-j][i] = mat[row-1-i][col-1-j];
				mat[row-1-i][col-1-j] = temp;
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		RotateNowNow r = new RotateNowNow();
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		r.rotate(mat);
	}
}
