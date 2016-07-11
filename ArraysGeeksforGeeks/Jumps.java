
public class Jumps {

	public int jump(int[] arr, int l, int h)
	{
		if(l==h)
			return 0;
		if(arr[l]==0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=l+1;i<=h && i<=arr[l]+l;i++)
		{
			int jumps = jump(arr,i,h);
			if(jumps!=Integer.MAX_VALUE && jumps+1<min)
				min = jumps+1;
		}
		return min;
	}
	
	public int jumps_dp(int[] arr, int n)
	{
		int[] jumps  = new int[n];
		if(n==0 || arr[0]==0)
			return Integer.MAX_VALUE;
		jumps[0]=0;
		for(int i=1;i<n;i++)
		{
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++)
			{
				if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE)
				{
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		return jumps[n-1];
	}
	
	public int jumps_dp2(int[] arr, int n)
	{
		int[] jumps  = new int[n];
		if(n==0)
			return 0;
		jumps[n-1]=0;
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]==0)
				jumps[i]=Integer.MAX_VALUE;
			else
			{
				if(arr[i]>=n-i-1)
					jumps[i]=1;
				else
				{
					int min = Integer.MAX_VALUE;
					for(int j=i+1;j<n && j <= i+arr[i];j++)
					{
						if(min>jumps[j])
							min = jumps[j];
					}
					if(min!=Integer.MAX_VALUE)
					{
						jumps[i] = min+1;
					}
					else
						jumps[i] = min;
				}
			}
		}
		return jumps[0];
	}
	public static void main(String args[])
	{
		int[] arr = {1, 10, 9, 3, 2, 3, 6, 8, 9, 5};
		Jumps j = new Jumps();
		System.out.println(j.jump(arr, 0, 9));
		System.out.println(j.jumps_dp(arr, 10));
		System.out.println(j.jumps_dp2(arr, 10));
	}
}
