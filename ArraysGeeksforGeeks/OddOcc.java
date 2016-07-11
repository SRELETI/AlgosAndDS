import java.util.Arrays;


public class OddOcc {
	public static void main(String args[])
	{
		int[] arr = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
		odd(arr);
		odd2(arr);
		odd3(arr);
	}
	public static void odd(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			int count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					count++;
			}
			if(count%2==1)
				System.out.print(arr[i]+" ");
		}
	}
	public static void odd2(int[] arr)
	{
		Arrays.sort(arr);
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			if(i==arr.length-1 && count==1)
			{
				System.out.println(arr[i]);
				return;
			}
			else if(arr[i]==arr[arr.length-1] && count !=1)
				return;
			if(arr[i]==arr[i+1])
				count++;
			if(count%2==1 && arr[i]!=arr[i+1])
			{
				System.out.println(arr[i]);
				count=1;
			}
			if(arr[i]!=arr[i+1])
				count=1;
		}
	}
	public static void odd3(int[] arr)
	{
		int xor=0;
		int x=0,y=0;
		for(int i=0;i<arr.length;i++)
			xor=xor^arr[i];
		int set_bit=~(xor-1);
		System.out.println(set_bit);
		int set_bit_no=xor & set_bit;
		System.out.println(set_bit_no);
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i] & set_bit_no)!=0)
				x=x^arr[i];
			else
				y=y^arr[i];
		}
		System.out.println(x+" "+y);
	}
}
