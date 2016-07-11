import java.util.Date;


public class AnagramStrings {

	public boolean anagram(String text1, String text2) {
		if(text1.length()!=text2.length())
			return false;
		int[] count = new int[256];
		int i;
		for(i=0;i < text1.length() && i<text2.length();i++) {
			count[text1.charAt(i)]++;
			count[text2.charAt(i)]--;
		}
		if(i<text1.length() || i<text2.length())
			return false;
		for(i=0;i<count.length;i++) {
			if(count[i]!=0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		AnagramStrings a = new AnagramStrings();
	//	System.out.println(a.anagram("geeksforgeeks", "forgeekpgeeks"));
		long val = 1000*24*24*60;
		long val2 = 1420070340000L-1419984060000L;
		System.out.println(val2+" "+val);
	}
}
