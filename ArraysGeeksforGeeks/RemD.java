
public class RemD {

	public void remove(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])]<0)
				System.out.print(Math.abs(arr[i])+" ");
			else
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		
	}
	public static void main(String args[])
	{
		RemD d = new RemD();
		int[] arr = {1,2,3,1,3,6,6};
		d.remove(arr);
	}
}
