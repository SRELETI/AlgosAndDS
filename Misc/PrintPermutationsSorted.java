import java.util.Arrays;


public class PrintPermutationsSorted {

	public static void main(String args[]) {
		char[] text = {'A','B','C'};
		PrintPermutationsSorted p = new PrintPermutationsSorted();
		p.print(text);
	}
	public void print(char[] text) {
		if(text.length==0)
			return;
		Arrays.sort(text);
	//	System.out.println(Arrays.toString(text));
		boolean isFinished = false;
		while(isFinished==false) {
			System.out.println(Arrays.toString(text));
			
			int j;
			for(j=text.length-2;j>=0;j--) {
				if(text[j]<text[j+1])
					break;
			}
			if(j==-1)
				isFinished=true;
			else
			{
				int ceil = findCeil(text,text[j],j+1,text.length-1);
				swap(text,ceil,j);
				reverse(text,j+1,text.length-1);
			}
		}
	}
	
	private void swap(char[] text, int start, int end) {
		char temp = text[start];
		text[start] = text[end];
		text[end] = temp;
	}
	
	private  void reverse(char[] text, int i, int j) {
		while(i<j) {
			char temp = text[i];
			text[i] = text[j];
			text[j] = temp;
			i++;
			j--;
		}
	}
	private int findCeil(char[] text, char c, int start, int end) {
		int ceilIndex = start;
		for(int i=start+1;i<=end;i++) {
			if(text[i]>c && text[i]<text[ceilIndex]) 
				ceilIndex = i;
		}
		return ceilIndex;
	}
}
