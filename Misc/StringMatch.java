
public class StringMatch {

	public void match(String text, String pat) {
		int tlen = text.length();
		int plen = pat.length();
		for(int i=0;i<=tlen-plen;i++) {
			int j=0;
			for(j=0;j<plen;j++) {
				if(text.charAt(i+j)!=pat.charAt(j))
					break;
			}
			if(j==plen) {
				System.out.println("The pat found at index "+i);
			}
		}
	}
	
	public static void main(String args[]) {
		StringMatch s = new StringMatch();
		s.match("AAAAD", "AAAD");
	}
} 
