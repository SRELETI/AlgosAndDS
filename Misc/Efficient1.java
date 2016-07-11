
public class Efficient1 {

	public void find(int[][] mat) {
		if(mat.length==0)
			return;
		int i=0;
		int j=mat[0].length;
		int rowNum=-1;
		while(i<mat.length && j>0) {
			if(mat[i][j-1]==0) { 
				j--;
				rowNum=i;
			}
			else
				i++;
		}
		System.out.println(rowNum);
	}
	
	public static void main(String args[]) {
		int[][] mat = {{1,0,0},{1,0,0},{1,0,0}};
		Efficient1 e = new Efficient1();
		e.find(mat);
	}
}
