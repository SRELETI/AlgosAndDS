import java.util.Arrays;


public class AddNumbers {
	public int[] adding(int[] arr1, int[] arr2)
	{
		int c,rem=0;
		int[] arr3=new int[arr1.length+1];
		for(int i=arr1.length-1;i>=0;i--)
		{
			c=arr1[i]+arr2[i]+rem;
			if(c>=10)
			{
				int k=c%10;
				arr3[i+1]=k;
				rem=1;
			}
			else
			{
				arr3[i+1]=c+rem;
				rem=0;
			}
		}
		arr3[0]=rem;
		return arr3;
	}
	public static void main(String args[])
	{
		int[] arr1={7,8,9};
		int[] arr2={3,2,1};
		AddNumbers ad=new AddNumbers();
		System.out.print(Arrays.toString(ad.adding(arr1,arr2)));
	}
}
