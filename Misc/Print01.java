
public class Print01 {

	public void sum(int[][] mat) {
		if(mat.length==0) 
			return;
		boolean[][] result = new boolean[mat.length][mat[0].length];
		int count=0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(result[i][j]==false) {
					if(mat[i][j]==1) {
						if(findNext(mat,i,j,result)>=1)
							count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	
	private int findNext(int[][] mat, int i, int j, boolean[][] result) {
		result[i][j] = true;
		int count=0;
		if(i-1>=0 && mat[i-1][j]==1 && result[i-1][j]==false) {
			count++;
			count += findNext(mat,i-1,j,result);
		}
		if(j-1>=0 && mat[i][j-1]==1 && result[i][j-1]==false) {
			count++;
			count += findNext(mat,i,j-1,result);
		}
		if(i+1<mat.length && mat[i+1][j]==1 && result[i+1][j]==false) {
			count++;
			count += findNext(mat,i+1,j,result);
		}
		if(j+1<mat.length && mat[i][j+1]==1 && result[i][j+1]==false) {
			count++;
			count +=findNext(mat,i,j+1,result);
		}
		return count;
	}
	
	public static void main(String args[]) {
		Print01 p = new Print01();
		int[][] mat = {{1,1,0,0},{1,1,1,0},{1,1,0,0}};
		p.sum(mat);
	}
}
