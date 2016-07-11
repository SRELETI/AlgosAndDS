import java.util.Arrays;
import java.util.HashMap;


public class ArrSubS {
	
	public void sub(int[] arr1, int[] arr2)
	{
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i= 0;
		int j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
				i++;
			else if(arr1[i]>arr2[j])
				break;
			else 
			{
				i++;
				j++;
			}
		}
		if(j==arr2.length)
		{
			System.out.println("yes is it a subset of arr1");
		}
		else
		{
			System.out.println("No it doesnt look like it is a subset");
		}
	}
	
	public boolean sub2(int[] arr1, int[] arr2)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
		for(int i=0;i<arr1.length;i++)
		{
			if(h.containsKey(arr1[i]))
			{
				h.put(arr1[i], h.get(arr1[i])+1);
			}
			else
				h.put(arr1[i],1);
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(h.containsKey(arr2[i]) && h.get(arr2[i])!=0)
				h.put(arr2[i], h.get(arr2[1])-1);
			else 
				return false;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		ArrSubS a = new ArrSubS();
		int[] arr = {11,1,13,21,3,3};
		int[] arr2 = {11,3,7,1};
		a.sub(arr, arr2);
		System.out.println(a.sub2(arr, arr2));
	}
}
