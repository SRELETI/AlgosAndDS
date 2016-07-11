import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StackDelimiter3App {
	public static void main(String args[]) throws IOException
	{
		String input;
		while(true)
		{
			System.out.println("Enter a string containing delimiters");
			input=getString();
			if(input.equals(""))
			{
				System.out.println("no string entered, bye");
				break;
			}
			else
			{
				StackDelimiters2 sid= new StackDelimiters2(input);
				sid.check();
			}
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
}
