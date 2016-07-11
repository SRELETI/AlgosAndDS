import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Median {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(true)
		{
			System.out.println("Please enter an element to add to the input stream ");
			int s=Integer.parseInt(getString());
			if(s==0)
				break;
			arr.add(s);
			insertionSort(arr);
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
	public static void insertionSort(ArrayList<Integer> arr)
	{
		int n=arr.size();
		for(int j=1;j<arr.size();j++)
		{
			int key=arr.get(j);
			int i=j-1;
			while(i>=0 && arr.get(i)>key)
			{
				arr.set(i+1, arr.get(i));
				i=i-1;
			}
			arr.set(i+1, key);
		}
		if(arr.size()%2==1)
			System.out.println(arr.get(arr.size()/2));
		if(arr.size()%2==0)
			System.out.println((arr.get(n/2)+arr.get((n/2)-1))/2);
	}
}
