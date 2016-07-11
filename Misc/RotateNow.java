import java.util.Arrays;



public class RotateNow {

	public void rotate(int[][] mat) {
		if(mat.length==0)
		{
			System.out.println("null");
			return;
		}
		int[][] result = new int[mat.length][mat.length];
		
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				result[j][mat.length-1-i] = mat[i][j];
			}
		}
		
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				mat[i][j] = result[i][j];
			}
		}
		
		System.out.println(Arrays.deepToString(mat));
	}
	
	public void rotate2(int[][] mat) {
		if(mat.length==0)
			return;
		int layers = mat.length/2;
		int length = mat.length-1;
		for(int i=0;i<layers;i++)
		{
			for(int j=i;j<length-i;j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[length-j][i];
				mat[length-j][i] = mat[length-i][length-j];
				mat[length-i][length-j] = mat[j][length-i];
				mat[j][length-i] = temp;
			}
		}
		
		System.out.println(Arrays.deepToString(mat));
	}
	
	public static void main(String args[]) {
		RotateNow r = new RotateNow();
		int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
		r.rotate(m);
		int[][] m2 = {{1,2,3},{4,5,6},{7,8,9}};
		r.rotate2(m2);
	}
}
