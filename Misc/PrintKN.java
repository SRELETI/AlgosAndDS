
public class PrintKN {
	
	public static void main(String args[])
	{
		int arr[]={1,2,3,4,5};
		int r=3;
		printCom(arr,r);
	
	}
	public static void printCom(int[] arr,int r)
	{
		int length=arr.length;
		int data[]=new int[r];
		comb(arr,data,0,length-1,0,r);
	}
	public static void comb(int[] arr,int data[],int start,int end,int index,int r)
	{
		if(index==r)
		{
			for(int i=0;i<data.length;i++)
			{
				System.out.print(data[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=end && end-i+1>=r-index;i++)
		{
			data[index]=arr[i];
			comb(arr,data,i+1,end,index+1,r);
		}
	}
}
