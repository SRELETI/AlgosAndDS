import java.util.Arrays;


public class Matrix_Multiplication_S {
	public int[][] add(int A[][],int B[][])
	{
		int C[][]=new int[A.length][A.length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<B.length;j++)
			{
				C[i][j]=A[i][j]+B[i][j];
			}
		}
		return C;
	}
	public int[][] sub(int A[][],int B[][])
	{
		int C[][]=new int[A.length][A.length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<B.length;j++)
			{
				C[i][j]=A[i][j]-B[i][j];
			}
		}
		return C;
	}
	public int[][] multiply(int A[][],int B[][])
	{
		int n=A.length;
		int R[][]=new int[n][n];
		if(n<=1)
		{
			R[0][0]=A[0][0]*B[0][0];
			return R;
		}
			int A11[][]=new int[n/2][n/2];
			int A12[][]=new int[n/2][n/2];
			int A21[][]=new int[n/2][n/2];
			int A22[][]=new int[n/2][n/2];
			int B11[][]=new int[n/2][n/2];
			int B12[][]=new int[n/2][n/2];
			int B21[][]=new int[n/2][n/2];
			int B22[][]=new int[n/2][n/2];
		
			split(A,A11,0,0);
			split(A,A12,0,n/2);
			split(A,A21,n/2,0);
			split(A,A22,n/2,n/2);
			
			split(B,B11,0,0);
			split(B,B12,0,n/2);
			split(B,B21,0,n/2);
			split(B,B22,n/2,n/2);
			
			
			
			
			int[][] M1=multiply(add(A11,A22),add(B11,B22));
			int[][] M2=multiply(add(A21,A22),B11);
			int[][] M3=multiply(A11,sub(B12,B22));
			int[][] M4=multiply(A22,sub(B21,B11));
			int[][] M5=multiply(add(A11,A12),B22);
			int[][] M6=multiply(sub(A21,A11),add(B11,B12));
			int[][] M7=multiply(sub(A12,A22),add(B21,B22));
			
			
			int[][] C11=add(sub(add(M1,M4),M5),M7);
			int[][] C12=add(M3,M5);
			int[][] C21=add(M2,M4);
			int[][] C22=add(sub(add		(M1,M3),M2),M6);
			
			join(C11,R,0,0);
			join(C12,R,0,n/2);
			join(C21,R,n/2,0);
			join(C22,R,n/2,n/2);
		return R;
	}
	public void split(int[][] Parent,int[][] child,int iB,int jB)
	{
		for(int i1=0,i2=iB;i1<child.length;i1++,i2++)
		{
			for(int j1=0,j2=jB;j1<child.length;j1++,j2++)
			{
				child[i1][j1]=Parent[i2][j2];
			}
		}
	}
	public void join(int[][] child,int[][] parent, int iB,int jB)
	{
		for(int i1=0,i2=iB;i1<child.length;i1++,i2++)
		{
			for(int j1=0,j2=jB;j1<child.length;j1++,j2++)
			{
				parent[i2][j2]=child[i1][j1];
			}
		}
	}
	public static void main(String args[])
	{
		int[][] A={{1,0},{0,1}};
		int[][] B={{1,0},{0,1}};
		Matrix_Multiplication_S mms=new Matrix_Multiplication_S();
		int R[][]=mms.multiply(A, B);
		System.out.print(Arrays.deepToString(R));		
	}
}
			

