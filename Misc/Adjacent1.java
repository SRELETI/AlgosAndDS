
public class Adjacent1 {

	private void printNow(int[][] mat) {
		if(mat.length==0)
			return;
		int oneCount=0;
		boolean[][] result = new boolean[mat.length][mat[0].length];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				if(result[i][j]==false) {
					if(mat[i][j]==1) {
						oneCount++;
						findSurround(i,j,result,mat);
					}
				}
			}
		}
		System.out.println(oneCount);
	}
	
	private void findSurround(int i,int j, boolean[][] result,int[][] mat) {
		if(result[i][j]!=true) {
			result[i][j] = true;
			if(i+1<result.length && mat[i+1][j]==1) {
				findSurround(i+1,j,result,mat);
			}
			if(i-1>=0 && mat[i-1][j]==1) {
				findSurround(i-1,j,result,mat);
			}
			if(j+1<result[0].length && mat[i][j+1]==1) {
				findSurround(i,j+1,result,mat);
			}
			if(j-1>=0 && mat[i][j-1]==1) {
				findSurround(i,j-1,result,mat);
			}
		}
	}
	
	public static void main(String args[]) {
		Adjacent1 a = new Adjacent1();
		int[][] mat  = {{1,0,0,0},{0,0,0,1},{1,1,0,0}};
		a.printNow(mat);
	}
}
