import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class MaxPathInArray {

	public void maxPath(int[] arr, int[] arr2)
	{
		int sum1 = 0;
		int sum2 =0;
		int total =0;
		int i=0,j=0;
		while(i<arr.length && j<arr2.length)
		{
			if(arr[i]<arr2[j])
				sum1 = sum1+arr[i++];
			else if(arr[i]>arr2[j])
				sum2 = sum2+arr2[j++];
			else
			{
				total = total + Math.max(sum1,sum2);
				sum1=0;
				sum2=0;
				if(i<arr.length && j<arr2.length && arr[i]==arr2[j])
				{
					total = total+arr[i++];
					j++;
				}
			}
		}
		while(i<arr.length)
		{
			sum1 = sum1+arr[i++];
		}
		while(j<arr2.length)
		{
			sum2 = sum2+arr2[j++];
		}
		total = total + Math.max(sum1,sum2);
		System.out.println(total);
	}
	
	public static void main(String args[])
	{
		int[] arr = {-3, 2, 3, 1, 6};
		int[] arr2 = {2, 1, 8, 3,4};
		MaxPathInArray m = new MaxPathInArray();
	//	m.maxPath(arr, arr2);
	//	m.sortArr(arr, arr2);
	//	m.sumSubArr(arr, 280);
		m.subArr(arr);
		
	}
	
	public void sortArr(int[] arr, int[] arr1)
	{
		Map<Integer,Integer> h = new TreeMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(arr[i])==false)
				h.put(arr[i], 1);
			else
			{
				int val = h.get(arr[i]);
				h.put(arr[i], val+1);
			}
		}
		int index=0;
		for(int i=0;i<arr1.length;i++)
		{
			if(h.containsKey(arr1[i])==true)
			{
				int val = h.get(arr1[i]);
				while(val>0)
				{
					arr[index++]=arr1[i];
					val--;
				}
				h.remove(arr1[i]);
			}
		}
		
		for(Entry<Integer,Integer> m : h.entrySet())
		{
			int val = m.getValue();
			while(val>0)
			{
				arr[index++]=m.getKey();
				val--;
			}
			
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void sumSubArr(int[] arr, int val)
	{
		int start = 0;
		int end = 0;
		int diff = arr.length;
		int cur_diff;
		int sum= 0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			end++;
			while(sum>val)
			{
				cur_diff = end-start;
				if(cur_diff<diff)
					diff = cur_diff;
				sum = sum-arr[start];
				start++;
			}
		}
		System.out.println(diff);
	}
	
	public boolean subArr(int[] arr)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		int sum =0;
		int start=0;
		int end =0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			if(arr[i]==0)
			{
				start=i;
				end = i;
				System.out.println(start+" "+end);
				return true;
			}
			if(sum ==0)
			{
				end =i;
				System.out.println(start+" "+end);
				return true;
			}
			if(h.get(sum)!=null)
			{
				start = start+1;
				end = i;
				System.out.println(start+" "+end);
				return true;
			}
			h.put(sum, 1);
		}
		return false;
	}
}
