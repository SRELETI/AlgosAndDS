
public class HornerRule {
	public int horner(int[] arr,int degree,int x)
	{
		int result=arr[degree];
		for(int i=degree-1;i>=0;i--)
		{
			result=result*x+arr[i];
		}
		return result;
	}
	public static void main(String args[])
	{
		int arr[]={6,5,4,1};
		int degree=arr.length-1;
		int x=2;
		HornerRule hr=new HornerRule();
		System.out.print(hr.horner(arr, degree, x));
	}
}
