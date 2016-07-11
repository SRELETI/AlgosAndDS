
public class RepeationAllowed {
	private static int count=0;
	public void repeat(String text, int start, int end, String result) {
		if(result.length()==text.length()) {
			System.out.println(result);
			count++;
			return;
		}
		for(int i=0;i<=end;i++) {
			repeat(text,i,end,result+text.charAt(i));
		}
	}
	
	public static void main(String args[]) {
		RepeationAllowed r = new RepeationAllowed();
		String text= "ABC";
		r.repeat(text, 0, text.length()-1, "");
		System.out.println(count);
	}
}
