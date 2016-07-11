import java.util.Arrays;


public class BooleanMatrix {

	public void bool(int[][] matrix) {
		if(matrix.length==0)
			return;
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(row[i]==1 || col[j]==1) {
					matrix[i][j] = 1;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		BooleanMatrix b = new BooleanMatrix();
		int[][] matrix = {{1,0},{0,0}};
	//	b.bool(matrix);
		b.sec_method(matrix);
		System.out.println(Arrays.deepToString(matrix));
		}
	
	public void sec_method(int[][] arr) {
		if(arr.length==0)
			return;
		boolean rowFlag = false;
		boolean colFlag = false;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0]==1)
			{
				rowFlag = true;
				break;
			}
		}
		
		for(int j=0;j<arr[0].length;j++) {
			if(arr[0][j]==1) {
				colFlag = true;
				break;
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[i].length;j++) {
				if(arr[i][j]==1) {
					arr[i][0] = 1;
					arr[0][j] = 1;
				}
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[i].length;j++) {
				if(arr[i][0] == 1 || arr[0][j]==1)
					arr[i][j] = 1;
			}
		}
		
		if(rowFlag ==true) {
			for(int i=0;i<arr.length;i++) {
				arr[i][0] =1;
			}
		}
		if(colFlag==true) {
			for(int j=0;j<arr[0].length;j++) {
				arr[0][j] = 1;
			}
		}
	}
	}

