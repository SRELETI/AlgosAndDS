import java.util.Arrays;


public class DigitsSum {

	public void digitsSum(int num)
	{
		if(num==0)
		{
			return;
		}
		if(num<=9)
		{
			System.out.println(10+num);
			return;
		}
		int[] arr = new int[100];
		int j=0;
		for(int i=9;i>1;i--)
		{
			while(num%i==0)
			{
				num = num/i;
				arr[j]=i;
				j++;
			}
		}
		if(num>9)
		{
			System.out.println("No such number possible ");
			return;
		}
	//	System.out.println(Arrays.toString(arr));
		for(int i=j-1;i>=0;i--)
		{
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		DigitsSum d = new DigitsSum();
		d.digitsSum(1);
	}
}
