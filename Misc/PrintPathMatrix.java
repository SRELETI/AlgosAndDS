class wrapper_max_now {
	int val=0;
	String path="";
}
public class PrintPathMatrix {
	wrapper_max_now w = new wrapper_max_now();
	public void print(int[][] mat, int row, int col, String res, int sum) {
		if(row<mat.length) {
			if(res.length()==0) 
				res = String.valueOf(mat[row][col]);
			else
				res = res + "-" +mat[row][col];
			sum = sum + mat[row][col];
			
			if(row==mat.length-1) {
		//		print(mat,row+1,col,res);
				if(w.val<sum) {
					w.val = sum;
					w.path = res;
				}
			//	System.out.println(res);
				return;
			}
			
			if(col-1>=0) {
				print(mat,row+1,col-1,res,sum);
			}
			print(mat,row+1,col,res,sum);
			if(col+1<mat[0].length)
				print(mat,row+1,col+1,res,sum);
		}
	}
	
	public void printNow(int[][] mat, int row, int col, String res, int sum) {
		for(int i=col;i<mat[0].length;i++) {
			print(mat,row,i,res,sum);
		}
		System.out.println("Largest path "+w.path+" value is "+w.val);
	}
	public static void main(String args[]) {
		PrintPathMatrix p = new PrintPathMatrix();
		int[][] mat = {{1,2,3},{4,5,6},{9,8,7}};
		p.printNow(mat, 0, 0, "", 0);
	}
}
