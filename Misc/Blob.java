
public class Blob {

	public void count(int[][] mat) {
		if(mat.length==0) {
			return;
		}
		boolean[][] result = new boolean[mat.length][mat[0].length];
		int count=0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				if(result[i][j]==false) 
				{
					if(mat[i][j]==1) 
					{
					//	System.out.println(count);
						int temp = findSur(i,j,result,mat);
						if((temp>=2)) {
							count++;
						//	System.out.println(count+" "+temp);
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	public int findSur(int i, int j, boolean[][] result, int[][] mat) {
		int count=0;
			result[i][j]=true;
			if(i+1<mat.length && mat[i+1][j]==1 && result[i+1][j]!=true) {
				count++;
				count+= findSur(i+1,j,result,mat);
			}
			if(j+1<mat[i].length && mat[i][j+1]==1 && result[i][j+1]!=true){
				count++;
				count+= findSur(i,j+1,result,mat);
			}
			if(i-1>=0 && mat[i-1][j]==1 && result[i-1][j]!=true) {
				count++;
				count+= findSur(i-1,j,result,mat);
			}
			if(j-1>=0 && mat[i][j-1]==1 && result[i][j-1]!=true){
				count++;
				count+= findSur(i,j-1,result,mat);
			}
		return count;
	}
	
	public static void main(String args[]) {
		Blob b = new Blob();
		int[][] mat = {{1,1,1,1},{0,1,1,0},{0,1,0,0},{1,1,0,0}};
		b.count(mat);
	}
}
