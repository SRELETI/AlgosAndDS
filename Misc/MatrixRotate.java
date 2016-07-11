import java.util.Arrays;


public class MatrixRotate {

	public void rotate(int[][] matrix) {
		if(matrix==null || matrix.length==0)
			return;
		int layers = matrix.length/2;
		int length = matrix.length-1;
		
		for(int i=0;i<layers;i++)
		{
			for(int j=i;j<length-i;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[length-j][i];
				matrix[length-j][i] = matrix[length-i][length-j];
				matrix[length-i][length-j] = matrix[j][length-i];
				matrix[j][length-i] = temp;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
	public void rotate_now(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return;
        int[][] result = new int[matrix.length][matrix.length];
        int length = matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                result[j][length-i] = matrix[i][j];
            }
        }
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j] = result[i][j];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
	
	public static void main(String args[]) {
		MatrixRotate m = new MatrixRotate();
		int[][] matrix = {{2,3,4,5},{3,4,5,6},{4,5,6,7},{5,6,7,8}};
		m.rotate_now(matrix);
	}
}
