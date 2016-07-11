import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MedStream {

	public static void sort(int[] arr, int length)
	{
		for(int i=1;i<=length;i++)
		{
			int key =arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		MedStream m = new MedStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int i=0;
		while(i<10)
		{
			System.out.println("Enter the number: ");
			arr[i]=Integer.parseInt(br.readLine());
			sort(arr,i);
			i++;
			if(i%2==0)
			{
				System.out.println((arr[i/2]+arr[(i/2)-1])/2);
			}
			else
				System.out.println(arr[i/2]);
		}
		System.out.println("End of the program");
	}
}
