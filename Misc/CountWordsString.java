
public class CountWordsString {

	public int count(String text) {
		if(text.length()==0)
			return 0;
		int count=0;
		int i=0;
		boolean flag = true;
		while(i<text.length()) {
			if(text.charAt(i)==' ' || text.charAt(i)=='\t' || text.charAt(i)=='\n')
				flag = true;
			else if(flag==true) {
			//	System.out.println(text.charAt(i));
				count++;
				flag = false;
			}
			i++;
		}
		return count;
	}
	
	public static void main(String args[]) {
		CountWordsString c = new CountWordsString();
		String text = "One two          three\n  four\nfive  ";
		System.out.println(c.count(text));
	}
}
