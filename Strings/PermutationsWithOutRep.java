import java.util.Arrays;



public class PermutationsWithOutRep {

	public void print(String text1)
	{
		int m = text1.length();
		
		char[] ss = text1.toCharArray();
		Arrays.sort(ss);
		text1 = new String(ss);
		StringBuilder text = new StringBuilder(text1);
		System.out.println(text1.length());
		boolean isFinished = false;
		while(!isFinished)
		{
			System.out.println(text);
			int i;
			for(i=m-2;i>=0;i--)
			{
				if((int)text.charAt(i)<(int)text.charAt(i+1))
					break;
			}
			if(i==-1)
				isFinished = true;
			else
			{
				int ceilIndex = getCeil(text,text.charAt(i),i+1,m-1);
				char temp = text.charAt(i);
				text.setCharAt(i, text.charAt(ceilIndex));
				text.setCharAt(ceilIndex, temp);
				reverse(text,i+1,m-1);		
			}
		}
	}
	
	private void reverse(StringBuilder text, int start, int end)
	{
		while(start<end)
		{
			char temp = text.charAt(start);
			text.setCharAt(start, text.charAt(end));
			text.setCharAt(end, temp);
			start++;
			end--;
		}
	}
	private int getCeil(StringBuilder text, char first, int start, int end)
	{
		int first_index = start;
		for(int i=first_index+1;i<=end;i++)
		{
		//	System.out.println(first_index+" "+ i);
			if(text.charAt(i)>first && text.charAt(i)<text.charAt(first_index))
				first_index = i;
		}
		return first_index;
	}
	
	public static void main(String  args[])
	{
		PermutationsWithOutRep p = new PermutationsWithOutRep();
		String s = "AABB";
		p.print(s);
	}
}
