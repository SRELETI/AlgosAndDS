
public class MatrixMaxPath {

	public void printMax(int[][] mat) {
		if(mat.length==0)
			return;
		for(int i =0; i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(i==0) {
					if(j==0)
						mat[i][j]=mat[i][j];
					else
						mat[i][j] = mat[i][j-1]+mat[i][j];
				}
				else
				{
					if(j==0) 
						mat[i][j] = mat[i-1][j] + mat[i][j];
					else
						mat[i][j] = mat[i][j] + Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		System.out.println(mat[mat.length-1][mat[0].length-1]);
	}
	public static void main(String args[]) {
		MatrixMaxPath m = new MatrixMaxPath();
		int[][] mat  = {{1,2,3,4},{5,6,7,8}};
		m.printMax(mat);
	}
}
