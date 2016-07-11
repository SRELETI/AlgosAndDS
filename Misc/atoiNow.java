
public class atoiNow {

	public int convert(String text) {
		if(text.length()==0)
			return 0;
		int i=0;
		while(i<text.length() && text.charAt(i)==' ')
			i++;
		int negFlag = 1;
		if(text.charAt(i)=='-' || text.charAt(i)=='+')
			negFlag = text.charAt(i)=='+' ? 1 : -1;
		int val = 0;
		while(i<text.length() && text.charAt(i)>='0' && text.charAt(i)<='9') {
			if(val>Integer.MAX_VALUE/10 || val==Integer.MAX_VALUE/10 && text.charAt(i)=='7') {
				if(negFlag==-1)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}
			else
				val = val*10+text.charAt(i)-'0';
			i++;
		}
		return val*negFlag;
	}
	
	public static void main(String args[]) {
		atoiNow a = new atoiNow();
		
	}
}
