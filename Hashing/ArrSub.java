import java.util.Arrays;
import java.util.HashMap;


public class ArrSub {

	private int[] arr1;
	private int[] arr2;
	
	public ArrSub(int size1,int size2)
	{
		arr1 = new int[size1];
		arr2 = new int[size2];
	}
	
	public boolean isSub(int[] arr1,int[] arr2)
	{
		int i,j;
		for(i=0;i<arr2.length;i++)
		{
			for(j=0;j<arr1.length;j++)
			{
				if(arr2[i]==arr1[j])
					break;
			}
			if(j==arr2.length)
				return false;
		}
		return true;
	}
	
	public boolean isSubCheck(int[] arr1,int[] arr2)
	{
		Arrays.sort(arr1);
		
		for(int i=0;i<arr2.length;i++)
		{
			if(binary(arr1,arr2[i],0,arr1.length-1) == -1)
				return false;
		}
		return true;
	}
	
	private int binary(int[] arr1,int val, int start, int end)
	{
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(arr1[mid]==val)
			return mid;
		else if(arr1[mid]<val)
			return binary(arr1,val,mid+1,end);
		else 
			return binary(arr1,val,start,mid-1);
	}
	
	public boolean isSubset(int[] arr1, int[] arr2)
	{
		HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			if(h.containsKey(arr1[i])==false)
				h.put(arr1[i], 1);
			else
			{
				int val = h.get(arr1[i]);
				h.put(arr1[i], val+1);
			}
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(h.containsKey(arr2[i])==false || h.get(arr2[i])==0)
				return false;
			else
			{
				int val = h.get(arr2[i]);
				h.put(arr2[i], val-1);
			}
		}
		return true;
	}
	
	
	public boolean isSubSET(int[] arr, int[] arr2)
	{
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		int i=0,j=0;
		while(i<arr.length && j<arr2.length)
		{
			if(arr[i]<arr2[j])
				i++;
			else if(arr[i]==arr2[j])
			{
				i++;
				j++;
			}
			else
				return false;
		}
		if(j<arr2.length)
			return false;
		return true;
	}
	
}
