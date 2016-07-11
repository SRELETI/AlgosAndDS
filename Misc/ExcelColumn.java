
public class ExcelColumn {

	public String column(int num) {
		if(num==0)
		{
			System.out.println("Invalid number ");
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while(num>0) {
			int mod = (num-1)%26;
			sb.append((char)('A'+mod));
			num = (int)((num-mod)/26);
		}
		reverse(sb,0,sb.length()-1);
	//	System.out.println(sb);
		return sb.toString();
	}
	
	public void reverse(StringBuilder sb, int left, int right) {
		while(left<right)
		{
			char temp = sb.charAt(left);
			sb.setCharAt(left, sb.charAt(right));
			sb.setCharAt(right, temp);
			left++;
			right--;
		}
	}
	
	public static void main(String args[]) {
		ExcelColumn e = new ExcelColumn();
		int num = 80;
		String result = e.column(num);
		System.out.println(e.columnNumber(result));
	}
	
	public int columnNumber(String name) {
		if(name.length()==0)
			return 0;
		int result = 0;
		for(int i=0;i<name.length();i++) {
			result = result*26+(name.charAt(i)-'A'+1);
		}
		return result;
			
	}
}
