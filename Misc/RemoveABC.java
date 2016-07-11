
public class RemoveABC {

	public void remove(char[] text) {
		if(text.length==0)
			return;
		int status = 1;
		int j=0;
		for(int i=0;i<text.length;i++) {
			if(status==1 && text[i]!='a' && text[i]!='b') {
				text[j]= text[i];
				j++;
			}
			if(status==2 && text[i]!='c') {
					text[j]='a';
					j++;
				if(text[i]!='a' && text[i]!='b') {
					text[j]=text[i];
					j++;
				}
			}
			status = text[i]=='a' ? 2:1;
			if(j>1 && text[j-2]=='a' && text[j-1]=='c')
				j=j-2;
		}
		if(status==2) {
			text[j]='a';
			j++;
		}
		for(int i=0;i<j;i++) 
			System.out.print(text[i]+" ");
	}
	
	public static void main(String args[]) {
		RemoveABC r = new RemoveABC();
		char[] text = {'a','a','x','a','a','c','c','c','x','c','a','c'};
		r.remove(text);
	}
}
