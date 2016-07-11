import java.util.Arrays;


public class IncreasingSubSeq {

	public void subSeq(int[] arr)
	{
		int[] ls = new int[arr.length];
		int[] rl = new int[arr.length];
		int[] temp_arr = arr;
		Arrays.sort(temp_arr);
		for(int i=0;i<arr.length;i++)
		{
			ls[i] = findFloor(temp_arr,0,arr.length-1,arr[i]);
		}
		int max=Integer.MAX_VALUE;
		rl[rl.length-1]=0;
		max =arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--)
		{
			rl[i]=max;
			if(arr[i]>max)
				max = arr[i];
		}
		
		max = 0;
		int temp;
		int l=0,j=0,k=0;
		for(int i=0;i<arr.length;i++)
		{
			temp = arr[i]*ls[i]*rl[i];
			if(temp>max)
			{
				l =arr[i];
				j=ls[i];
				k=rl[i];
				max = temp;
			}
		}
		System.out.println(l+" "+j+" "+k);
	}
	
	private int findFloor(int[] arr,int left,int right, int a)
	{
		if(a<=arr[left])
			return 0;
		if(a>=arr[right])
			return arr[right];
		int middle = (left+right)/2;
		if(middle>left && arr[middle-1]<a && a<=arr[middle])
			return arr[middle-1];
		if(middle<right && arr[middle]< a && a<=arr[middle+1])
			return arr[middle];
		if(a<arr[middle])
			return findFloor(arr,left,middle-1,a);
		else
			return findFloor(arr,middle+1,right,a);
	}
	
	public static void main(String args[])
	{
		int[] arr = {6, 7, 8, 1, 2, 3, 9, 10};
		IncreasingSubSeq i = new IncreasingSubSeq();
		i.subSeq(arr);
	}
}
