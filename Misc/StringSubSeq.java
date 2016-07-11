
public class StringSubSeq {

	public boolean isSub(String text, String text2) {
		int i=0;
		int j=0;
		while(i<text.length() && j<text2.length()) {
			if(text.charAt(i)==text2.charAt(j)) {
				j++;
			}
			i++;
		}
		return j==text2.length();
	}
	
	public boolean isSub_rec(String text, String text2) {
		if(text2.length()==0) 
			return true;
		if(text.length()==0)
			return false;
		if(text.charAt(0)==text2.charAt(0))
			return isSub_rec(text.substring(1, text.length()),text2.substring(1, text2.length()));
		return isSub_rec(text.substring(1, text.length()),text2);
	}
	
	public static void main(String args[]) {
		StringSubSeq s = new StringSubSeq();
		String text = "geeksforgeeks";
		String text2 = "gksrek";
		System.out.println(s.isSub(text, text2));
		System.out.println(s.isSub_rec(text, text2));
	}
}
