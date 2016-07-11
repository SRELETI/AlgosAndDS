
public class Kadane2D {
	private int start=-1;
	private int finish=-1;
	public void kadane(int[][] mat) {
		if(mat.length==0)
			return;
		int row = mat.length;
		int col = mat[0].length;
		int maxSum = Integer.MIN_VALUE;
		int left = -1;
		int right = -1;
		int top = -1;
		int bottom = -1;
		for(int i=0;i<col;i++) {
			int[] temp = new int[row];
			for(int j=i;j<col;j++) {
				for(int k=0;k<row;k++) {
					temp[k] = temp[k]+mat[k][j];
				}
				int sum = kadane(temp,row);
				if(sum>maxSum) {
					maxSum = sum;
					left = i;
					right = j;
					top = start;
					bottom = finish;
				}
			}
		}
		
		for(int i=top;i<=bottom;i++) {
			for(int j=left;j<=right;j++) {
				System.out.print(maxSum);
			}
		}
	}
	
	private int kadane(int[] temp, int rows) {
		if(temp.length==0)
			return 0;
		int maxSum = temp[0];
		int cur_sum = temp[0];
		for(int i=1;i<temp.length;i++) {
			cur_sum = Math.max(temp[i], maxSum+temp[i]);
			if(cur_sum>maxSum) {
				finish = start = i;
				maxSum = cur_sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String args[]) {
		Kadane2D k = new Kadane2D();
		int[][] matrix = {{1,2,-1,-4,-20},{-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}};
		k.kadane(matrix);
	}
}
