import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Triangle {
	public static void main(String args[]) throws IOException
	{
		while(true)
		{
			System.out.println("Enter a number, to find out the number at that particular position : ");
			int num=getValue();
			if(num>8)
			{
				System.out.println("Invalid Entry");
				return;
			}
			int result=triangle_recursion(num);
			System.out.println("The value at "+num+"th position is: "+ result);
		}
	}
	public static int triangle_recursion(int data)
	{
		if(data==1)
			return 1;
		else
			return data+triangle_recursion(data-1);
	}
	public static int triangle_value(int num)
	{
		int total=0;
		while(num>0)
		{
			total=total+num;
			num--;
		}
		return total;
	}
	public static int getValue() throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		int result=Integer.parseInt(s);
		return result;
	}
}
