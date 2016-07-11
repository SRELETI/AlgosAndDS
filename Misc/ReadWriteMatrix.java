import java.util.Arrays;


public class ReadWriteMatrix {

	public void write(int[][] mat) {
		if(mat.length==0)
			return;
		int[][] result = new int[mat.length][mat[0].length];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(i%2==0)
					result[j][i] = mat[i][j];
				else
					result[j][i] = mat[i][mat[0].length-1-j];
			}
		}
		System.out.println(Arrays.deepToString(result));
	}
	
	public static void main(String args[]) {
		ReadWriteMatrix r = new ReadWriteMatrix();
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		r.write(mat);
	}
}
