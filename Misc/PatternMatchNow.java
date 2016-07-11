
public class PatternMatchNow {

	public void matching(String text, String pattern) {
		if(text.length()==0 || pattern.length()==0)
			return;
		for(int i=0;i<=text.length()-pattern.length();i++) {
			int j;
			for(j=0;j<pattern.length();j++) {
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==pattern.length()) {
				System.out.println("Pattern found from index "+i+" to "+(i+j)+" and the string is "+text.substring(i,i+j));
			}
		}
	}
	
	public static void main(String args[]) {
		PatternMatchNow p = new PatternMatchNow();
		String text = "THIS IS A TEST TEXT";
		String pattern = "TEST";
		p.matching(text, pattern);
		
	}
}
