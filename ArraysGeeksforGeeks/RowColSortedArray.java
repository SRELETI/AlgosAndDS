
public class RowColSortedArray {
	public static void main(String args[])
	{
		int[][] arr = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
		System.out.println(search(arr,35));
	}
	public static int search(int[][] arr, int element)
	{
		int i=0;
		int n=arr.length;
		int j=n-1;
		while(i<n && j>=0)
		{
			if(arr[i][j]==element)
				return 1;
			if(arr[i][j]>element)
				j--;
			else
				i++;
		}
		return -1;
	}
}
