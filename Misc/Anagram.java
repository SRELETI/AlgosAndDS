
public class Anagram {
	private String input;
	private char[] inp;
	private int size;
	private int count;
	public Anagram(String in)
	{
		input=in;
		size=input.length();
		inp=new char[size];
		for(int i=0;i<size;i++)
		{
			inp[i]=input.charAt(i);
		}
		count=0;
	}
	public void doAnagram(int newSize)
	{
		if(newSize==1)
			return;
		for(int j=0;j<newSize;j++)
		{
			doAnagram(newSize-1);
			if(newSize==2)
				displayWord();
			rotate(newSize);
		}
		
	}
	public void displayWord()
	{
		if(count<99)
			System.out.print(" ");
		if(count<9)
			System.out.print(" ");
		System.out.print(++count+ " ");
		for(int i=0;i<size;i++)
		{
			System.out.print(inp[i]);
		}
		System.out.print("   ");
		if(count%10==0)
			System.out.println();
	}
	public void rotate(int newSize)
	{
		int j;
		int position= size-newSize;
		char temp=inp[position];
		for(j=position+1;j<size;j++)
		{
			inp[j-1]=inp[j];
		}
		inp[j-1]=temp;
	}
}
