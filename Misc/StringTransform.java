import java.util.Arrays;


public class StringTransform {
	
	public static void main(String args[]) {
		StringTransform s = new StringTransform();
		char[] text = {'a','1','b','2','c','3','d','4','e','5','f','6','g','7'};
		s.transform(text);
		System.out.println(Arrays.toString(text));
	}
	public void transform(char[] text) {
		if(text.length==0)
			return;
		int lengthRem = text.length;
		int lengthFirst = 0;
		int shift = 0;
		while(lengthRem>0) {
			int k =0;
			while((((int)Math.pow(3, k))+1)<=lengthRem)
				k++;
			lengthFirst = (int)Math.pow(3, k-1)+1;
			lengthRem -= lengthFirst;
			cycleIterate(text,shift,lengthFirst);
			reverse(text,shift/2,shift-1);
			reverse(text,shift,shift+(lengthFirst/2)-1);
		//	System.out.println(shift+lengthFirst/2);
			reverse(text,shift/2,shift+(lengthFirst/2)-1);
		//	System.out.println(Arrays.toString(text));
			shift = shift+lengthFirst;
		}
	//	System.out.println(Arrays.toString(text));
	}
	
	private void reverse(char[] text, int a, int b) {
		while(a<b) {
			char temp = text[a];
			text[a]= text[b];
			text[b]= temp;
			a++;
			b--;
		}
	}
	public void cycleIterate(char[] text, int shift, int lengthFirst) {
	//	System.out.println(lengthFirst);
		for(int i=1;i<lengthFirst;i*=3) {
			int j=i;
			int item = j+shift;
		//	System.out.println(item);
			do {
				if(j%2==1) 
					j=(lengthFirst/2) + (j/2);
				else
					j=j/2;
		//		System.out.println(j);
				swap(text,j+shift,item);
			}while(j!=i);
		}
	}
	
	public void swap(char[] text, int a, int b) {
		char temp = text[a];
		text[a] = text[b];
		text[b]= temp;
	}
}
