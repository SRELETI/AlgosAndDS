
public class DArrayMax {

	public void findMax(int[][] arr)
	{
		int count=0;
		int max = Integer.MIN_VALUE;
		int index =0;
		for(int i=0;i<arr.length;i++)
		{
			count = 0;
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==1)
					count++;
			}
			if(count>max)
			{
				max = count;
				index = i;
			}
		}
		System.out.println("The row having highest number of 1's : "+index);
	}
	
	public void findMax_second(int[][] arr)
	{
		int count =0;
		int index =0;
		for(int i=0;i<arr.length;i++)
		{
			int start = findBS(arr,0,arr[i].length-1,i);
			if(start!=-1 && arr[i].length-start>count)
			{
				count = arr[i].length-start;
				index = i;
			}
		}
		System.out.println("The row having highest number of 1's: "+index);
	}
	
	public void findMax_third(int[][] arr)
	{
		int index = findBS(arr,0,arr[0].length-1,0);
		int final_row = 0;
		int count = arr[0].length-index;
		int temp=0;
		for(int i=1;i<arr.length;i++)
		{
			if(checkFirst(arr,i,index)==true)
			{
				temp = findBS(arr,0,arr[i].length-1,i);
				if(temp!=-1 && arr[i].length-temp>count)
				{
					count = arr[i].length-temp;
					index = temp;
					final_row = i;
				}
			}
		}
		System.out.println("The row with max 1's: "+final_row);
	}
	
	private boolean checkFirst(int[][] arr, int row, int col)
	{
		int temp = col-1;
		if(temp>=0 && arr[row][temp]==1)
			return true;
		else 
			return false;
	}
	
	private int findBS(int[][] arr, int low, int high, int row)
	{
		if(low>high)
			return -1;
		else
		{
			int middle = (low+high)>>1;
			if((middle==low || (middle>low && arr[row][middle-1]!=1)) && arr[row][middle]==1)
				return middle;
			if(arr[row][middle]==0)
				return findBS(arr,middle+1,high,row);
			else
				return findBS(arr,low,middle-1,row);
		}
	}
	
	public static void main(String args[])
	{
		int[][] arr = {{0,1,1,1},{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		DArrayMax d = new DArrayMax();
		d.findMax(arr);
		d.findMax_second(arr);
		d.findMax_third(arr);
		d.findMax_fourth(arr);
	}
	
	public void findMax_fourth(int[][] arr)
	{
		int j = findBS(arr,0,arr[0].length-1,0);
		int maxCount = arr[0].length-j;
		int index =0;
		for(int i=1;i<arr.length;i++)
		{
			while(j>=0 &&  arr[i][j]==1)
			{
				maxCount = arr[i].length-j;
				j=j-1;
				index =i;
			}
		}
		System.out.println("The row with max no of 1's: "+index);
	}
}
