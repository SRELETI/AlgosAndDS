import java.util.Arrays;


public class MagicSqaure {

	public void magic(int n)
	{
		int[][] magic = new int[n][n];
		int i=n/2;
		int j=n-1;
		int k=1;
		while(k<=n*n)
		{
			if(i==-1 && j==n)
			{
				j=j-2;
				i=0;
			}
			else
			{
				if(j==n)
					j=0;
				if(i==-1)
					i=n-1;
			}
			if(magic[i][j]!=0)
			{
				j=j-2;
				i++;
				continue;
			}
			else
			{
				magic[i][j]=k++;
			}
			i--;
			j++;
		}
		
		System.out.println(Arrays.deepToString(magic));
	}
	
	public static void main(String args[])
	{
		MagicSqaure m = new MagicSqaure();
		m.magic(2);
	}
}
