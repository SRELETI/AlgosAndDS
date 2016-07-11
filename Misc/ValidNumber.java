import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidNumber {
	

	public boolean valid(String s) {
		
		return s.matches("(\\s*)([+-]?)((\\.[0-9]+)|([0-9]+)((\\.([0-9]*))?((e)[+-]?([0-9]+))?)) (\\s*)");
	}
	
	public static void main(String args[]) {
		ValidNumber v = new ValidNumber();
		//System.out.println(v.valid("3"));
		String s="123 java.lang.String3323";
		System.out.println(v.isPhone(s));
	}
	public boolean isPhone(String s) {
		return s.matches("[0-9]{7}|[0-9]{3}[-\\s][0-9]{4}");
	}
}
