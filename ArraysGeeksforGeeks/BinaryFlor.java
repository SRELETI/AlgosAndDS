
public class BinaryFlor {

	public int floor(int[] arr, int element, int start, int end)
	{
		if(element<arr[start])
			return -1;
		if(element>=arr[end])
			return arr[end];
		int middle = (start) + (end -start)/2;
		if(middle>start && element< arr[middle] && element>=arr[middle-1])
			return arr[middle-1];
		else if(middle<end && element<arr[middle+1] && element>=arr[middle])
			return arr[middle];
		else if(element<arr[middle])
			return floor(arr,element,start,middle-1);
		else 
			return floor(arr,element,middle+1,end);
	}
	
	public static void main(String args[])
	{
		BinaryFlor b = new BinaryFlor();
		
		int[] arr = {1,2,8,10,10,12,19};
		System.out.println(b.floor(arr, 20, 0, arr.length-1));
	}
}
