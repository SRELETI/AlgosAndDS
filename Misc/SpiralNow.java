
public class SpiralNow {

	private void print(int[][] matrix) {
		if(matrix.length==0)
			return;
		int r_low = 0;
		int c_low = 0;
		int r_high = matrix.length;
		int c_high = matrix[0].length;
		int iterator;
		while(r_low<r_high && c_low < c_high) {
			iterator = c_low;
			while(iterator<c_high) {
				System.out.print(matrix[r_low][iterator]+" ");
				iterator++;
			}
			r_low++;
			
			iterator = r_low;
			while(iterator<r_high) {
				System.out.print(matrix[iterator][c_high-1]+" ");
				iterator++;
			}
			c_high--;
			
			if(r_low<r_high) {
				iterator = c_high-1;
				while(iterator>=c_low) {
					System.out.print(matrix[r_high-1][iterator]+" ");
					iterator--;
				}
				r_high--;
			}
			
			if(c_low<c_high) {
				iterator = r_high-1;
				while(iterator>=r_low) {
					System.out.print(matrix[iterator][c_low]+" ");
					iterator--;
				}
				c_low++;
			}
		}
	}
	
	public static void main(String args[]) {
		SpiralNow s = new SpiralNow();
		int[][] mat = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
		s.print(mat);
	}
}
