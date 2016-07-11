import java.util.HashMap;


public class LargestArr01 {

	public void largestArr(int[] arr)
	{
		int maxLength =-1;
		int startIndex=0;
		int sum;
		for(int i=0;i<arr.length;i++)
		{
			sum = (arr[i]==0?-1:1);
			for(int j=i+1;j<arr.length;j++)
			{
				sum = sum + (arr[j]==0?-1:1);
				if(sum==0 && j-i+1>maxLength)
				{
					maxLength = j-i+1;
					startIndex =i;
				}
			}
		}
		if(maxLength==-1)
			System.out.println("No such subarrays: ");
		else
			System.out.println("The array with longest 0's and 1's is: "+startIndex+" to "+(startIndex+maxLength-1));
		
	}
	
	public void largest_mod(int[] arr)
	{
		int maxLength = -1;
		int startIndex=0;
		int[] sumLeft = new int[arr.length];
		int max, min;
		sumLeft[0] = (arr[0]==0 ? -1:1);
		max = sumLeft[0];
		min = sumLeft[0];
		for(int i=1;i<arr.length;i++)
		{
			sumLeft[i]= sumLeft[i-1]+(arr[i]==0?-1:1);
			if(sumLeft[i]<min)
				min = sumLeft[i];
			if(sumLeft[i]>max)
				max = sumLeft[i];
		}
		
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(sumLeft[i]==0)
			{
				maxLength = i+1;
				startIndex=0;
			}
			if(h.containsKey(sumLeft[i]-min)==false)
				h.put(sumLeft[i]-min, i);
			else
			{
				if(i-h.get(sumLeft[i]-min)>maxLength)
				{
					maxLength = i-h.get(sumLeft[i]-min);
					startIndex = h.get(sumLeft[i]-min)+1;
				}
			}
		}
		if(maxLength!=-1)
		{
			System.out.println("THe max array with 1's and 0's is :"+startIndex+" to "+(startIndex+maxLength-1));
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {1, 0, 1, 1, 1, 0, 0};
		LargestArr01 l = new LargestArr01();
		l.largestArr(arr);
		l.largest_mod(arr);
	}
}
