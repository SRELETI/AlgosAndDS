
public class KMPPatternNow {

	public void matchNow(String text,String pattern) {
		if(text.length()==0 || pattern.length()==0)
			return;
		int[] lps = constructArray(pattern);
		int textL=0;
		int patL=0;
		while(textL<text.length()) {
			if(text.charAt(textL)==pattern.charAt(patL)){
				textL++;
				patL++;
			
			if(patL==pattern.length()) {
				System.out.println(text.substring(textL-patL, textL)+" indexes are "+(textL-patL)+" - "+(textL-1));
				patL = lps[patL-1];
				}
			}
			else {
				if(patL==0)
					textL++;
				else
				{
					patL = lps[patL-1];
				}
			}
		}
	}
	
	private int[] constructArray(String pattern) {
		int[] result = new int[pattern.length()];
		int len=0;
		int i=0;
		int size = pattern.length();
		result[i++] =0;
		while(i<size) {
			if(pattern.charAt(i)==pattern.charAt(len)) {
				len++;
				result[i] = len;
				i++;
			}
			else
			{
				if(len!=0) {
					len = result[len-1];
				}
				else
				{
					result[i]=0;
					i++;
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		KMPPatternNow k = new KMPPatternNow();
		String text ="AABAACAADAABAAABAA";
		String pattern = "AABA";
		k.matchNow(text, pattern);
	}
}
