
public class ExcelCol {

	public void findColumnName(int num)
	{
		int no = num-1;
		int numChar;
		StringBuilder sb = new StringBuilder();
		while(no>=0)
		{
			numChar = no%26+65;
			sb.append((char)numChar);
			no = (no/26)-1;
		}
		System.out.println(sb.reverse().toString());
	}
	
	public void findColumnNo(String name)
	{
		int result = 0;
		for(int i=0;i<name.length();i++)
		{
			result = result*26;
			result = result+name.charAt(i)-65+1;
		}
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		ExcelCol e = new ExcelCol();
		e.findColumnName(51);
		e.findColumnNo("AY");
	}
}
