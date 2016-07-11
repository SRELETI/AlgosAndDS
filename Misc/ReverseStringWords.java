
public class ReverseStringWords {

	public void reverse(String words) {
		int temp = 0;
		int i = 0;
		
		StringBuilder sb = new StringBuilder(words);
		
		while(temp<sb.length()) {
			temp++;
			if(temp==sb.length()) {
				reverse(sb,i,temp-1);
				break;
			}
			if(sb.charAt(temp)==' ') {
				reverse(sb,i,temp-1);
				i = temp;
			}
		}
		reverse(sb,0,words.length()-1);
		System.out.println(sb.toString());
	}
	
	private void reverse(StringBuilder sb, int start, int end) {
		while(start<end) {
			char temp = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, temp);
			start++;
			end--;
		}
	}
	
	public static void main(String args[]) {
		ReverseStringWords r = new ReverseStringWords();
		String words = " i like this  program very much";
		r.reverse(words);
	}
	
}
