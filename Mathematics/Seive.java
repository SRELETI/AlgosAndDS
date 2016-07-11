
public class Seive {

	public void find(int n)
	{
		if(n>=2)
		{
			int[] arr = new int[n];
			for(int i=1;i<n;i++)
			{
				if(arr[i]==0)
				{
					System.out.print((i+1)+" ");
					markNums(arr,i+1,n);
				}
			}
		}
	}
	
	private void markNums(int[] arr, int a, int n)
	{
		int i=2;
		int num = i*a;
		while(num<=n)
		{
			arr[num-1]=1;
			i++;
			num=i*a;
		}

	}
	public static void main(String args[])
	{
		Seive s = new Seive();
		s.find(30);
	}
}
