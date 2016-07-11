import java.util.Arrays;


public class MaxSumKK {

	public void sum(int[][] mat, int k) {
		if(mat.length==0) 
			return;
		int[][] res = new int[mat.length][mat[0].length];
		int row = mat.length;
		int col = mat[0].length;
		
		if(row<k || col<k) 
			return;
		int sum=0;
		
		for(int i=0;i<col;i++) {
			sum = sum+mat[0][i];
			res[0][i] = sum;
		}
		sum=0;
		for(int i=0;i<row;i++) {
			sum = sum+mat[i][0];
			res[i][0] = sum;
		}
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				res[i][j] = mat[i][j] - res[i-1][j-1] + res[i-1][j] + res[i][j-1]; 
			}
		}
		System.out.println(Arrays.deepToString(res));
		int max = 0;
		for(int j=0;j<=col-k;j++) {
			int temp = res[k-1][j+k-1] - (j>0 ? res[k-1][j-1]:0);
			if(temp>max) {
				max = temp;
			}
		}
		
		for(int i=0;i<=row-k;i++) {
			int temp = res[i+k-1][k-1] - (i>0 ? res[i-1][k-1]:0);
			if(temp>max) {
				max = temp;
			}
		}
	//	System.out.println(max);
		for(int i=1;i<=row-k;i++) {
			for(int j=1;j<=col-k;j++) {
				int temp  = res[i+k-1][j+k-1] + res[i-1][j-1] - res[i-1][j+k-1] - res[i+k-1][j-1];
				if(temp > max) 
					max =temp;
			}
		}
		
		System.out.println(max);
	}
	
	public static void main(String args[]) {
		MaxSumKK m = new MaxSumKK();
		int[][] mat = {{1,2,1,3,4},{2,1,3,1,4},{1,5,6,7,8},{1,2,1,2,1}};
		m.sum(mat, 2);
	}
}
