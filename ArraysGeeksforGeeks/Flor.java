
public class Flor {

	public int floor(int[] arr, int element)
	{
		if(element<arr[0])
			return -1;
		if(element>=arr[arr.length-1])
			return arr[arr.length-1];
		int i=0;
		for( i=0;i<arr.length-1;i++)
		{
			if(element>=arr[i] && element<arr[i+1])
			{
				break;
			}
		}
		return arr[i];
	}
	
	public static void main(String args[])
	{
		Flor f = new Flor();
		int[] arr = {1,2,8,10,10,12,19};
		System.out.println(f.floor(arr, 0));
		System.out.println(f.ceil(arr,0));
	}
	
	public int ceil(int[] arr, int element)
	{
		if(element<=arr[0])
			return arr[0];
		if(element>arr[arr.length-1])
			return -1;
		int i=0;
		for(i=0;i<arr.length-1;i++)
		{
			if(element> arr[i] && element<=arr[i+1])
				break;
		}
		return arr[i+1];
	}
}
