
public class MatrixZeros {

	public void setZeros(int[][] matrix) {
		if(matrix.length==0)
			return;
		boolean rowFlag = false;
		boolean colFlag = false;
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				rowFlag = true;
				break;
			}
		}
		
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i]==0) {
				colFlag = true;
				break;
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]= 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[0][j]==0 || matrix[i][0]==0) {
					matrix[i][j] = 0;
				}
			}
		}
		if(rowFlag==true) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0] = 0;
			}
		}
		if(colFlag==true) {
			for(int i=0;i<matrix[0].length;i++){
				matrix[0][i] = 0;
			}
		}
		
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
		 	if(matrix.length==0)
		 		return false;
	        int i = matrix.length-1;
	        int j = matrix[0].length-1;
	        while( i>=0 && j>=0) {
	        	if(matrix[i][j]==target)
	        		return true;
	        	else if(matrix[i][j]<target) {
	        		j--;
	        	}
	        	else 
	        		i++;		
	        	}
	        return false;
	        }
}