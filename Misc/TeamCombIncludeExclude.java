import java.util.Arrays;


public class TeamCombIncludeExclude {
	public static void main(String args[])
	{
		int arr[]={2,1,1};
		int r=2;
		printComb(arr,r);
	}
	public static void printComb(int arr[],int r)
	{
		int length=arr.length;
		int data[]= new int[r];
		Arrays.sort(arr);
		combTeam(arr,data,0,0,r);
	}
	public static void combTeam(int arr[],int data[],int i,int index,int r)
	{
		if(index==r)
		{
			for(int j=0;j<r;j++)
				System.out.print(data[j]+" ");
			System.out.println();
			return;
		}
		if(i>=arr.length)
			return;
		
		data[index]=arr[i];
		combTeam(arr,data,i+1,index+1,r);
		while(arr[i]==arr[i+1])
			i++;
		combTeam(arr,data,i+1,index,r);
		
	}
	
}
