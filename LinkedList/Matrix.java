
public class Matrix {

	public String[][] arr;
	
	public Matrix(int rows, int cols)
	{
		arr = new String[rows][cols];
	}
	
	public void insertMatrix()
	{
		for(int j=0;j<64;j++)
		{
			if(j==31)
				arr[0][j]="*";
			else
				arr[0][j]="-";
		}
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(1<=j && j<=62 && !(arr[i-1][j-1]=="*" && arr[i-1][j+1] =="*" && arr[i-1][j]=="-") && ((arr[i-1][j]=="-" && arr[i-1][j-1]=="*") || (arr[i-1][j]=="-" && arr[i-1][j+1]=="*") ) )
					arr[i][j]="*";
				else
					arr[i][j]="-";
			}
		}
	}
	
	public void print()
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		Matrix m = new Matrix(32,64);
		
		m.insertMatrix();
		
		m.print();
	}
}
