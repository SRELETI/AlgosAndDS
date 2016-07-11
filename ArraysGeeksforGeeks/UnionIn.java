
public class UnionIn {

	public void union(int[] arr1, int[] arr2)
	{
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				System.out.print(arr1[i]+" ");
				i++;
			}
			else if(arr2[j]<arr1[i])
			{
				System.out.print(arr2[j]+" ");
				j++;
			}
			else
			{
				System.out.print(arr1[i]+" ");
				i++;
				j++;
			}
		}
		while(i<arr1.length)
			System.out.print(arr1[i++]+" ");
		while(j<arr2.length)
			System.out.print(arr2[j++]+" ");
		System.out.println();
	}
	
	public void intersection(int[] arr1, int[] arr2)
	{
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
				i++;
			else if(arr2[j]<arr1[i])
				j++;
			else
			{
				System.out.print(arr1[i]+" ");
				i++;
				j++;
			}
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		UnionIn i = new UnionIn();
		int[] arr1 = {1,3,4,5,7};
		int[] arr2 = {2,3,5,6};
		i.union(arr1, arr2);
		i.intersection(arr1, arr2);
	}
}
