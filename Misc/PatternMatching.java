
public class PatternMatching {

	public boolean pattern(String text1, String text2) {
		if(text1.length()==0 && text2.length()==0)
			return true;
		if(text1.charAt(0)=='*' && text1.length()==1 && text2.length()==0)
			return false;
		if(text1.charAt(0)=='?' || text1.charAt(0)==text2.charAt(0))
			return pattern(text1.substring(1, text1.length()),text2.substring(1,text2.length()));
		if(text1.charAt(0)=='*') 
			return pattern(text1.substring(1, text1.length()),text2) || pattern(text1,text2.substring(1, text2.length()));
		return false;
	}
}
