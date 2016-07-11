

public class StableMarriage {

	public void find(int[][] arr)
	{
		int[] womenPref = new int[arr[0].length];
		boolean[] freeMen = new boolean[arr[0].length];
		int n = arr[0].length;
		for(int i=0;i<arr[0].length;i++)
		{
			womenPref[i]=-1;
			freeMen[i]=false;
		}
		
		int freeCount=0;
		while(freeCount<n)
		{
			int m;
			for(m=0;m<n;m++)
			{
				if(freeMen[m]==false)
				{
					break;
				}
			}
			for(int i=0;i<n && freeMen[m]==false;i++)
			{
				int women = arr[m][i];
				if(womenPref[women-n]==-1)
				{
					womenPref[women-n] = m;
					freeMen[m]=true;
					freeCount++;
				}
				else
				{
					int m1 = womenPref[women-n];
					if(isStableMarr(arr,m,m1,women)==false)
					{
						womenPref[women-n]=m;
						freeMen[m]=true;
						freeMen[m1]=false;
					}
				}
			}
		}
		for(int i=0;i<womenPref.length;i++)
		{
			System.out.println((i+n) +" "+womenPref[i]);
		}
	}
	
	public boolean isStableMarr(int[][] arr, int m, int m1, int women)
	{
		for(int i=0;i<arr[0].length;i++)
		{
			if(arr[women][i]==m1)
				return true;
			if(arr[women][i]==m)
				return false;
		}
		return false;
	}
	public static void main(String args[])
	{
		int [][] arr = {{7, 5, 6, 4},
		        {5, 4, 6, 7},
		        {4, 5, 6, 7},
		        {4, 5, 6, 7},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3}};
		StableMarriage s = new StableMarriage();
		s.find(arr);
	}
}
