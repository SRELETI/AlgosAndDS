
public class CountAndSay {

	private String count(int n) {
		if(n==0)
			return "";
		if(n==1)
			return "1";
		String prev;
		StringBuilder cur = new StringBuilder("1");
		int count =1;
		char say;
		for(int i=1;i<n;i++) {
			prev = cur.toString();
			cur = new StringBuilder();
			say = prev.charAt(0);
			for(int j=1;j<prev.length();j++) {
				if(prev.charAt(j)==say)
					count++;
				else
				{
					cur.append(count);
					cur.append(say);
					count = 1;
					say = prev.charAt(j);
				}
			}
			cur.append(count).append(say);
		}
		return cur.toString();
	}
}
