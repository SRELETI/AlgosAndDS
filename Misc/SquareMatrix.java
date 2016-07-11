
public class SquareMatrix {

	private void transpose(int[][] mat, int n) {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}
	
	private void print(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void rotate(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0;i<row/2;i++) {
			for(int j=i;j<col-i-1;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[row-1-j][i];
				mat[row-1-j][i] = mat[row-1-i][col-1-j];
				mat[row-1-i][col-1-j] = mat[j][col-1-i];
				mat[j][col-1-i] = temp;
			}
		}
	}
	public static void main(String args[]) {
		SquareMatrix s = new SquareMatrix();
	//	int[][] mat = {{1,2,3,4,5,0},{6,7,8,9,10,0},{11,12,13,14,15,0},{16,17,18,19,20,0},{21,22,23,24,25,0},{26,27,28,29,30,0}};
	//	s.transpose(mat, 5);
	//	s.rotate(mat);
	//	s.print(mat);
		int[] mat = {1,2,3,4,5,6};
		s.printTran(mat,2,3);
		s.transpose(mat, 2,3);
		s.rotateNow(mat,3,2);
		s.printTran(mat, 3, 2);
	}
	
	private void rotateNow(int[] mat,int r,int c) {
		for(int i=0;i<r;i++) {
			int low = 0;
			int high = c-1;
			while(low<high) {
				int temp = mat[i*c+low];
				mat[i*c+low] = mat[i*c+high];
				mat[i*c+high] = temp;
				low++;
				high--;
			}
		}
	}
	
	private void printTran(int[] mat, int r, int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(mat[i*c+j]+" ");
			}
			System.out.println();
		}
	}
	public void transpose(int[] mat, int r, int c ) {
		if(mat.length==0)
			return;
		boolean result[] = new boolean[r*c];
		int size = r*c-1;
		int cycle;
		int t;
		int next;
		result[0]=result[size] =true;
		int i=1;
		while(i<size) {
			cycle  = i;
			t =i;
			do 
			{
				next = (i*r)%size;
				int temp =mat[next];
				mat[next] = mat[t];
				mat[t] = temp;
				result[i]=true;
				i = next;
			}while(i!=cycle);
			i=1;
			while(i<size && result[i]==true)
				i++;
		}
	}
}
