
public class CountDecoding {

	public int count(int[] arr,int start, int end)
	{
		if(end-start==0 || end-start==1)
			return 1;
		int count = 0;
		if(arr[end-1]>0)
			count = count(arr,start,end-1);
		if(arr[end-2]<2 || arr[end-2]==2 && arr[end-1]<=7)
			count = count+count(arr,start,end-2);
		return count;
	}
	
	public static void main(String args[])
	{
		CountDecoding c = new CountDecoding();
		int[] arr = {1,2,8};
		System.out.println(c.count(arr, 0, arr.length));
		System.out.println(c.count3(arr));
	}
	
	public int count2(int[] arr)
	{
		if(arr.length==0 || arr.length==1)
			return 1;
		int result[]  = new int[arr.length+1];
		result[0]=1;
		result[1]=1;
		for(int i=2;i<=arr.length;i++)
		{
			if(arr[i-1]>0)
				result[i]= result[i-1];
			if(arr[i-2]<2 || arr[i-2]==2 && arr[i-1]<=7)
				result[i]=result[i]+result[i-2];
		}
		return result[arr.length];
	}
	
	public int count3(int[] arr)
	{
		if(arr.length==0 || arr.length==1)
			return 1;
		int a=1;
		int b=1;
		int c =0;
	//	int temp=b;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				c = b;
			}
			if(arr[i-1]<2 || arr[i-1]==2 && arr[i]<=7)
			{
				c = c + a;	
			}
			a=b;
			b=c;
			c=0;
		}
		return b;
	}
}
