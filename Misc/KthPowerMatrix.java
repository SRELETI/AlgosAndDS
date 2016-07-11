
public class KthPowerMatrix {

	public int[][] kthPower(int[][] mat, int k, int N) {
		if(k==0)
			return Identity(N);
		if(k==1)
			return mat;
		int [][] result = kthPower(mat,k/2,N);
		if(k%2==1) {
			return multiply(multiply(result,result),mat);
		}
		else
			return multiply(result,result);
	}
	
	private int[][] multiply(int[][] mat, int[][] sec) {
		int[][] result = new int[mat.length][mat[0].length];
		for(int i =0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				for(int k=0;k<sec[0].length;k++) {
				result[i][j] += mat[i][k]*sec[k][j];
				}
			}
		}
		return result;
	}
	
	private void print(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		KthPowerMatrix k = new KthPowerMatrix();
		int[][] mat = {{2,2},{2,2}};
		int[][] res = k.kthPower(mat, 10, 2);
		k.print(res);
	}
	
	private int[][] Identity(int n) {
		int[][] mat = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++){
				mat[i][j]=1;
			}
		}
		return mat;
	}
}
