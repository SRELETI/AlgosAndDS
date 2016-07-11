import java.util.Arrays;


public class PrintStringSpace {

	public void input(String s,char[] ch) {
		int n= s.length();
		if(n==0)
			return;
		ch[0]=s.charAt(0);
		iterate(s,1,1,ch,n);
	}
	
	private void iterate(String s,int index, int chIndex, char[] ch, int n) {
		if(index==n)
		{
			ch[chIndex]='\0';
			System.out.println(Arrays.toString(ch));
			return;
		}
		ch[chIndex] =s.charAt(index);
		iterate(s,index+1,chIndex+1,ch,n);
		ch[chIndex] = ' ';
		ch[chIndex+1] = s.charAt(index);
		s.charAt(index);
		iterate(s,index+1,chIndex+2,ch,n);
	}
	
	public static void main(String args[]) {
		PrintStringSpace p = new PrintStringSpace();
		String s="ABCDEFG";
		int n= s.length();
		char[] ch = new char[n+n];
		p.input(s,ch);
	}
}
