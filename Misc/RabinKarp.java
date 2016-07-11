
public class RabinKarp {
	private static final int d = 256;
	public void patternMatch(String text, String pat) {
		if(text.length()==0 || pat.length()==0)
			return;
		int patL = pat.length();
		int textL = text.length();
		int p=0;
		int t=0;
		int h=1;
		int q=101;
		for(int i=0;i<patL-1;i++) {
			h = (h*d)%q;
		}
		
		for(int i=0;i<patL;i++) {
			p = (p*d+pat.charAt(i))%q;
			t = (t*d+text.charAt(i))%q;
		}
	//	System.out.println(p+" "+t);
		for(int i=0;i<=textL-patL;i++) {
			if(p==t) {
				int j;
				for(j=0;j<patL;j++) {
					if(pat.charAt(j)!=text.charAt(i+j))
						break;
				}
				if(j==patL) {
					System.out.println("pattern found from "+(i)+" to "+(i+patL-1));
				}
			}
			if(i<textL-patL) {
				t = (d*(t-text.charAt(i)*h)+text.charAt(i+patL))%q;
				if(t<0) 
					t= t+q;
			}
		}
	}
	
	public static void main(String args[]) {
		RabinKarp r = new RabinKarp();
		String text = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		r.patternMatch(text, pat);
	}
}
