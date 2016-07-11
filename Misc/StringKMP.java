
public class StringKMP {

	public void find(String text, String pat) {
		if(text.length()==0 || pat.length()==0)
			return;
		
		int[] lps = constructLPS(pat);
		
		int patI = 0;
		int textI=0;
		while(textI<text.length()){
			if(text.charAt(textI)==pat.charAt(patI)) {
				textI++;
				patI++;
			if(patI==pat.length()){
				System.out.println("Pattern found at "+(textI-patI));
				patI = lps[patI-1];
			}
			}
			else
			{
				if(patI==0) 
					textI++;
				else
				{
					patI = lps[patI-1];
				}
			}
		}
	}
	
	
	private int[] constructLPS(String pat) {
		int[] result = new int[pat.length()];
		result[0]=0;
		int i=1;
		int len = 0;  //length of the previous longest prefix suffix string
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len ++;
				result[i] = len;
				i++;
			}
			else
			{
				if(len==0) {
					result[i] = 0;
					i++;
				}
				else
					len = result[len-1];
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		StringKMP s = new StringKMP();
		s.find("ABABDABACDABABCABAB", "ABABCABAB");
	}
}
