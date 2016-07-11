import java.util.Arrays;


public class CStyleString {

	public static void main(String args[]) {
		CStyleString c = new CStyleString();
		String res = c.reverseString("abc\0");
		System.out.println(res);
	}
	
	public String reverseString(String cStyle) {
		if(cStyle.length()<=2) {
			return cStyle;
		}
		int start = 0;
		int end = cStyle.length()-2;
		char[] result = cStyle.toCharArray();
		
		while(start<end) {
			char temp = result[start];
			result[start] = result[end];
			result[end] = temp;
			end--;
			start++;
		}
		String res = Arrays.toString(result);
		return res;
	}
}
