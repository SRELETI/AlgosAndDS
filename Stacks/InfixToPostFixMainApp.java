
public class InfixToPostFixMainApp {
	public static void main(String args[])
	{
		InfixToPostMain ifp = new InfixToPostMain("a+b*(c^d-e)^(f+g*h)-i");
		ifp.converter();
		//ifp.postFix();
	}
	
}
