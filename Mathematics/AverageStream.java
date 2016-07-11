import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AverageStream {

	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int prev_avg = 0;
		int n=0;
		while(true)
		{
			System.out.println("Enter a number: ");
			int new_num = Integer.parseInt(br.readLine());
			int new_avg = getAvg(prev_avg,n,new_num);
			System.out.println("The avg is "+new_avg);
			prev_avg = new_avg;
			n++;
		}
	}
	
	private static int getAvg(int prev_avg, int n, int num)
	{
		return ((prev_avg*n)+num)/(n+1);
	}
}
