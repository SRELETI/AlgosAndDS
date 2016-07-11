
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class TEsting {

	
	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder(10240);
	}
	
	
	private static String clean_textline(String text) {
		//replace some goofy chars with a space
	    text = text.replaceAll("\\x1a|\\x15|\\x16|\\x00|\\x9a|\\x8a", " ");

		return text;
	}
}
