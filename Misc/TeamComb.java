import java.util.Arrays;


public class TeamComb {
	public static void teamPrint(int[] arr,int r)
	{
		int length=arr.length;
		int data[]=new int[r];
		Arrays.sort(arr);
		printComb(arr,data,0,length-1,0,r);
	}
	public static void printComb(int[] arr,int[] data,int start,int end,int index,int r)
	{
		if(index==r)
		{
			for(int i=0;i<r;i++)
				System.out.print(data[i]+" ");
			System.out.println();
			return;
		}
		for(int i=start;i<=end && end-i+1>=r-index;i++)
		{
			data[index]=arr[i];
			printComb(arr,data,i+1,end,index+1,r);
			while(arr[i]==arr[i+1])
				i++;
		}
	}
	public static void main(String args[])
	{
		int arr[]={1,2,1};
		int r=2;
		teamPrint(arr,2);
	}
}
