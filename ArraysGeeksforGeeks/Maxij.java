
public class Maxij {
	public static void main(String args[])
	{
		int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(max(arr));
		System.out.println(max_diff(arr));
	}
	public static int max(int[] arr)
	{
		int result=-1;
		int max=-1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]>arr[i])
					result=j-i;
				if(result>max)
					max=result;
			}
		}
		return max;
	} 
	public static int max_diff(int[] arr)
	{
		int max_diff;
		int i,j;
		int[] leftMin = new int[arr.length];
		int[] rightMax = new int[arr.length];
		leftMin[0]=arr[0];
		for(i=1;i<arr.length;i++)
			leftMin[i]=Math.min(arr[i], leftMin[i-1]);
		rightMax[arr.length-1]=arr[arr.length-1];
		for(j=arr.length-2;j>=0;j--)
			rightMax[j]=Math.max(arr[j], rightMax[j+1]);
		i=0; 
		j=0;
		max_diff=-1;
		while(i<arr.length && j<arr.length)
		{
			if(leftMin[i]<rightMax[j])
			{
				max_diff=Math.max(max_diff, j-i);
				j=j+1;
			}
			else
			{
				i=i+1;
			}
		}
		return max_diff;
	}
}
