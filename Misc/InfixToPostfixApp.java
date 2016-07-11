import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InfixToPostfixApp {
	public static void main(String args[]) throws IOException
	{
		String input;
		Object result;
		while(true)
		{
			System.out.println("Please enter a valid infix notation");
			input=getString();
			if(input.equals(""))
				break;
			InfixToPostfix2 ifp = new InfixToPostfix2(input);
			result=ifp.postfixvalue(input);
			System.out.println("The output postfix notation is " +result);
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s;
		s=br.readLine();
		return s;
	}
}
