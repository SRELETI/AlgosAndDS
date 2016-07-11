import java.util.Arrays;


public class OXPrint {

	public void print(int m, int n) {
		if(m==0 && n==0)
			return;
		char[][] result = new char[m][n];
		int r_low = 0;
		int c_low = 0;
		int r_high = m;
		int c_high = n;
		int iterator;
		char val = 'X';
		while(r_low<r_high && c_low<c_high) {
			iterator = c_low;
			while(iterator<c_high) {
				result[r_low][iterator]= val;
				iterator++;
			}
			r_low++;
			
			iterator = r_low;
			while(iterator<r_high) {
				result[iterator][c_high-1] = val;
				iterator++;
			}
			c_high--;
			
			if(r_low<r_high) {
				iterator = c_high-1;
				while(iterator>=c_low) {
					result[r_high-1][iterator] = val;
					iterator--;
				}
				r_high--;
			}
			
			if(c_low<c_high) {
				iterator = r_high-1;
				while(iterator>=r_low) {
					result[iterator][c_low] = val;
					iterator--;
				}
				c_low++;
			}
			if(val=='X')
				val = 'O';
			else
				val = 'X';
		}
		
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		OXPrint o = new OXPrint();
		o.print(6, 7);
	}
}
