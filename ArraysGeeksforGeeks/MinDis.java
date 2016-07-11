
public class MinDis {
	
	public void min(int[] arr, int x, int y)
	{
		int min_dis = Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if((arr[i]==x && arr[j]==y)||(arr[i]==y && arr[j]==x) && (j-i<min_dis))
					min_dis = j-i;
			}
		}
		System.out.println(min_dis);
	}
	
	public void min_opt(int[] arr, int x, int y)
	{
		int prev = -1;
		int i=0;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]==x || arr[i]==y)
			{
				prev = i;
				break;
			}
		}
		int min_dis = Integer.MAX_VALUE;
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[j]==x || arr[j]==y)
			{
				if(arr[j]!=prev && j-prev<min_dis)
				{
					min_dis = j-prev;
					prev = j;
				}
				else
				{
					prev= j;
				}
			}
		}
		System.out.println(min_dis);
		
		
	}
	
	public static void main(String args[])
	{
		MinDis m = new MinDis();
		int[] arr = {3,5,4,2,6,3,0,0,5,4,8,3};
		int x =3;
		int y= 6;
		m.min(arr, x, y);
		m.min_opt(arr, x, y);
	}
}
