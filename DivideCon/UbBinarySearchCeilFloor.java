
public class UbBinarySearchCeilFloor {

	public int floor_cal(int[] arr,int key)
	{
		if(key<arr[0])
			return -1;
		if(key==arr[0])
			return arr[0];
		int l = 0;
		int r = arr.length;
		return floor(arr,l,r,key);
	}
	public int floor(int[] arr, int l, int r, int key)
	{
		int m;
		while((r-l)>1)
		{
			m = l+ (r-l)/2;
			if(arr[m]<=key)
				l=m;
			else
				r=m;
		}
		return arr[l];
	}
	
	public int ceil_cal(int[] arr,int key)
	{
		if(key>arr[arr.length-1])
			return -1;
		if(key==arr[arr.length-1])
			return arr[arr.length-1];
		int l =0;
		int r = arr.length;
		return ceil(arr,l,r,key);
	}
	
	public int ceil(int[] arr, int l, int r, int key)
	{
		int m;
		while(r-l>1)
		{
			m = l + (r-l)/2;
			if(arr[m]<=key)
				l=m;
			else 
				r=m;
		}
		return arr[r];
	}
	
	public static void main(String args[])
	{
		UbBinarySearchCeilFloor u = new UbBinarySearchCeilFloor();
		int[] arr = {1,3,5,7,9,12};
		for(int i=0;i<14;i++)
		{
			System.out.print("The floor for "+i+" is "+u.floor_cal(arr, i)+" ******* ");
			System.out.print("The ceil for  "+i+" is "+u.ceil_cal(arr, i));
			System.out.println();
		}
	}
}
