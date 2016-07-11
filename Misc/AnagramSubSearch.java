
public class AnagramSubSearch {

	public void search(String text, String pattern) {
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		
		for(int i=0;i<pattern.length();i++) 
			count1[pattern.charAt(i)]++;
		for(int i=0;i<pattern.length();i++) 
			count2[text.charAt(i)]++;
		
		for(int i=0;i<=text.length()-pattern.length();i++) {
			if(isIdentical(count1,count2))
			{
				System.out.println("pattern found at "+i);
			}
			if(i<text.length()-pattern.length()) {
				count2[text.charAt(i)]--;
				count2[text.charAt(i+pattern.length())]++;
			}
		}
	}
		
		public boolean isIdentical(int[] count1, int[] count2) {
			for(int i=0;i<256;i++) {
				if(count1[i]!=count2[i])
					return false;
			}
			return true;
		}
		
		public static void main(String args[]) {
			AnagramSubSearch a = new AnagramSubSearch();
			String text = "AAABABAA";
			String pattern = "AABA";
			a.search(text, pattern);
		}
}
