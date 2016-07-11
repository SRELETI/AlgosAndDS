
public class Transpose {

	public void transpose(int[] mat, int row, int col) {
		if(mat.length==0) {
			return;
		}
		int size = row*col-1;
		boolean[] isCompl = new boolean[size+1];
		int t;
		int cycle;
		int next;
		isCompl[0] = isCompl[size] = true;
		int i=1;
		while(i<size) {
			cycle = i;
			t = i;
			do {
				next = (i*row)%size;
				int temp = mat[next];
				mat[next] = mat[t];
				mat[t] = temp;
				isCompl[i] = true;
				i = next;
			}while(i!=cycle);
			
			i=1;
			while(i<size && isCompl[i]==true) {
				i++;
			}
		}
	}
	
	public void print(int[]mat,int r, int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(mat[i*c+j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Transpose t = new Transpose();
		int r = 5;
		int c = 6;
		int[] mat = new int[5*6];
		for(int i=0;i<mat.length;i++) {
			mat[i] =i+1;
		}
		t.print(mat, r, c);
		t.transpose(mat, r, c);
		t.print(mat, c, r);
	}
}
