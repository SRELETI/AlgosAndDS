import java.util.Arrays;


public class InsertionSortExample {

	public void insertion(int[] arr)
	{
		int key,j;
		for(int i=1;i<arr.length;i++)
		{
			key = arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]= key;
		}
	}
	
	public static void main(String args[])
	{
		InsertionSortExample i = new InsertionSortExample();
		int[] arr ={12,11,13,5,6};
		System.out.println("Before Sorting : "+Arrays.toString(arr));
		i.insertion(arr);
		System.out.println("After Sorting : "+Arrays.toString(arr));
		
	}
}
